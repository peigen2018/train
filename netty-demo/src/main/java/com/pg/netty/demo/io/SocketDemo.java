package com.pg.netty.demo.io;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SocketDemo {
    public static void main(String[] args) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
//        ServerSocket serverSocket = new ServerSocket(8090);
//
//
//        while (true){
//            Socket client = serverSocket.accept();
//            new Thread(()->{
//
//
//            });


//        }
        Long timestamp = System.currentTimeMillis();
        String secret = "this is secret";

        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
        System.out.println(sign);
    }
}
