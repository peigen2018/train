package com.pg.train.java.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLEncoder;

public class HTTPTools {
    public static void main(String[] args) {
        try {

            String data = URLEncoder.encode("name", "UTF-8") + "="
                    + URLEncoder.encode("hello", "UTF-8");
        

            String hostname = "10.92.2.252";
            int port = 5667;
            InetAddress addr = InetAddress.getByName(hostname);
            Socket socket = new Socket(addr, port);

            String path = "/";
     
            
            DataOutputStream wr = new DataOutputStream(socket.getOutputStream());
            
            wr.write(("GET " + path + " HTTP/1.1\r\n").getBytes());
            
    
            wr.write(("Host: ac.test.token.com \r\n").getBytes());
   
            Thread.sleep(15000);
            
            
            wr.write(("Content-Length: " + data.length() + "\r\n").getBytes());
            wr.write(("Content-Type: application/text/html\r\n").getBytes());
        
            
            wr.write(("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36\r\n").getBytes());
    

            wr.write("\r\n".getBytes()); 
 
           
      
         
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream(),
                    "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
            wr.flush();
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
