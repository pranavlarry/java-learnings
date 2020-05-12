package com.pranavlari.Collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/*
    Improvement over java.io (arguable), in java.io thread will block while reading and writing in java.nio the thread will not block
    java.io process data at 1 char or 1 byte at a time, in nio data are processed as 1 blocks
    You can use java.nio to create java.io streams
 */
public class Nio {
    private static Path path = FileSystems.getDefault().getPath("locationNIO.txt");

    public static void main(String[] args) {
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("hello there how are you");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            //can also use scanner(delimiter setting if needed) check SimpleIO
            String str = reader.readLine();
            System.out.println(str);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
