package com.pranavlari.Collections;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RandomAccess {
    /*
        file ptr, if it is at 100th byte after a read, in the next byte it will be at the same loc
        for locations(data's) with fixed size the location can be found by (n-1) * 30 assuming 30 is the size of each location
        if the size vary we keep an indexing for the locations and load that index file to memory initially
        index will be 3 byte id,start byte or offset , length of location or data
     */
    private static List<Employee> employees = Arrays.asList(new Employee(1, "Lari", "Development"),
            new Employee(2,"Pranav","Aricitect"),
            new Employee(3,"Kabali","Lead Developer"));
    private static Map<Integer,Index> indexTable = new LinkedHashMap<>();

    // to read data
    private static RandomAccessFile randRead;

    public static void main(String[] args) {

        //reading data
        System.out.println(getEmp(2).getName());
        close(); //don't forget to close the file

        //rwd indicate read write and allow synchronization write with multiple threads, if not we will have to manage synchronization
        try (RandomAccessFile randWriter = new RandomAccessFile("randEmployees.dat","rwd")) {
            randWriter.writeInt(employees.size());
            //total size of index = size of data * size per index * 4byte(int)
            int indexSize = employees.size() * 3 *Integer.BYTES;
            //Start location of data = index size + current file pointer + 4byte(int)
            int locationStart = (int) (indexSize + randWriter.getFilePointer() + Integer.BYTES);
            randWriter.writeInt(locationStart);
            //start point of index
            long indexStart = randWriter.getFilePointer();

            int startPointer = locationStart;
            randWriter.seek(startPointer);
            for(Employee employee : employees ) {
                randWriter.writeInt(employee.getId());
                randWriter.writeUTF(employee.getName());
                randWriter.writeUTF(employee.getDept());
                //casted to int because getFilePointer returns long for small data's int is good for large data keep it as long
                Index index = new Index(startPointer,(int)(randWriter.getFilePointer() - startPointer));
                indexTable.put(employee.getId(),index);
                startPointer = (int) randWriter.getFilePointer();
            }

            //seeking to index start location
            randWriter.seek(indexStart);

            for(int emid: indexTable.keySet()) {
                randWriter.writeInt(emid);
                randWriter.writeInt(indexTable.get(emid).getStart());
                randWriter.writeInt(indexTable.get(emid).getLength());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static  {
        try {
            randRead = new RandomAccessFile("randEmployees.dat","rwd");
            int dataSize = randRead.readInt();
            int dataStart = randRead.readInt();

            while ( randRead.getFilePointer() < dataStart) {
                int emid = randRead.readInt();
                int locStart = randRead.readInt();
                int locSize = randRead.readInt();
                indexTable.put(emid,new Index(locStart,locSize));
            }

//            indexTable.keySet().forEach(key -> System.out.println(key+" : "+indexTable.get(key).getStart()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Employee getEmp(int id) {
        int start = indexTable.get(id).getStart();
        try {
            //to skip reading id
            randRead.seek(start+4);
            return new Employee(id,randRead.readUTF(),randRead.readUTF());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close() {
        try {
            randRead.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
