package com.pg.train.java.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class UploadTools {

    public static byte[] getBytesFromFile(File f) {
        if (f == null){
            return null;
        }
        try{
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e){
        }
        return null;
    }


    public static void main(String[] args) throws IOException{
        Socket sock = new Socket();
        InetSocketAddress hostAddr = new InetSocketAddress("127.0.0.1", 8080);
        sock.connect(hostAddr);

        DataOutputStream dostream = new DataOutputStream(sock.getOutputStream());

        String boundaryTail = "\r\n-----------------------------2609120531336--\r\n";
        String c_FormData = "-----------------------------2609120531336\r\nContent-Disposition: form-data; name=\"%s\"\r\n\r\n%s\r\n";
        String c_FileData = "-----------------------------2609120531336\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: text/plain\r\n\r\n";

        String kv1 = String.format(c_FormData, "key1", "value1");
        String kv2 = String.format(c_FormData, "key2", "value2");
        String file = String.format(c_FileData, "torrent", "123.torrent");
        File file1=new File("C:\\Documents and Settings\\Administrator\\桌面\\哈哈.torrent");

        long ContentLength = kv1.getBytes().length + kv2.getBytes().length
                + file.getBytes().length
                + file1.length() //file content length
                + boundaryTail.getBytes().length;

        //write http head
        dostream.write("POST /btmanager/upload.do HTTP/1.1\r\n".getBytes());
        dostream.write("Accept: */*\r\n".getBytes());
        // dostream.write("Referer: http://192.168.1.102:8080/btmanager/MyJsp.jsp\r\n".getBytes());
        dostream.write("Accept-Language: zh-cn\r\n".getBytes());
        dostream.write("Content-Type: multipart/form-data; boundary=---------------------------2609120531336\r\n".getBytes());
        dostream.write("Accept-Encoding: gzip, deflate\r\n".getBytes());
        dostream.write("User-Agent: Mozilla/4.0 (Windows XP 5.1) Java/1. 6.0\r\n".getBytes());
        dostream.write("Host: 127.0.0.1:8080\r\n".getBytes());
        dostream.write(String.format("Content-Length: %d\r\n", ContentLength).getBytes());
        dostream.write("Connection: Keep-Alive\r\n".getBytes());
        dostream.write("Cache-Control: no-cache\r\n".getBytes());
        dostream.write("\r\n".getBytes());
        //write http data
        dostream.write(kv1.getBytes());
        dostream.write(kv2.getBytes());
        dostream.write(file.getBytes());
        dostream.write(getBytesFromFile(file1));   ////file content
        dostream.write(boundaryTail.getBytes());

        dostream.close();
        System.out.println(getBytesFromFile(file1).length);
        System.out.println(getBytesFromFile(file1).length);
    }
}
