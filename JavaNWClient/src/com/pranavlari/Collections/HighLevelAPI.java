package com.pranavlari.Collections;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class HighLevelAPI {

    public static void main(String[] args) {
        try {
//            URI uri = new URI("http://www.google.com?req=hello#test");
//            URL url = uri.toURL();
//            System.out.println(url.toString());
            //uri components, all urls are uri we can still convert url to uri to access the components methods
//            System.out.println(uri.getScheme());
//            System.out.println(uri.getSchemeSpecificPart());
//            System.out.println("Authority:"+uri.getAuthority());
//            System.out.println(uri.getUserInfo());
//            System.out.println(uri.getHost());
//            System.out.println(uri.getPort());
//            System.out.println(uri.getPath());
//            System.out.println(uri.getFragment());
//            System.out.println(uri.getQuery());

//            URL url = new URL("http://www.example.org");
            URL url = new URL("https://api.github.com/users/hadley/orgs");
//            Method 1
//            BufferedReader html = new BufferedReader(new InputStreamReader(url.openStream()));
//            Method 2
//            URLConnection urlConn = url.openConnection();
//            //allow writing
//            urlConn.setDoInput(true);
//            urlConn.connect();
//            BufferedReader html = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
//
//            String line = "";
//            while (line !=null) {
//                line = html.readLine();
//                System.out.println(line);
//            }
//
//            //getting header values
//            Map<String, List<String >> header = urlConn.getHeaderFields();
//
//            for(String key : header.keySet()) {
//                System.out.println("Key: "+key);
//                for(String s: header.get(key)) {
//                    System.out.print("Value: "+s);
//                }
//            }

            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            //this method implicitly call connect method
            int resCode = connection.getResponseCode();
            if(resCode == 200) {
                BufferedReader html = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line ="a";
                String data=new String();
                while (line != null) {
                    line = html.readLine();
                    if(line != null) {
                        data = line;
                    }
                    System.out.println(line);
                }
                JSONArray jarray = new JSONArray(data);
                JSONObject jobj = new JSONObject(jarray.getJSONObject(0).toString());
                System.out.println(jobj.getString("login"));


            }
            else {
                System.out.println("Connection issue");
            }
        }
        catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
