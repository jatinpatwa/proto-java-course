package io;

import example.simple.Simple;
import example.simple.SimpleOuterClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoMain {

    private static void writeTo(Simple message, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            message.writeTo(fos);
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void readFrom(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            Simple message = Simple.parseFrom(fis);
            System.out.println(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Simple message = Simple.newBuilder()
                .setName("A Name")
                .setIsSimple(true)
                .setId(34)
                .build();

        String path = "simple.bin";

        writeTo(message, path);
        readFrom(path);
    }
}
