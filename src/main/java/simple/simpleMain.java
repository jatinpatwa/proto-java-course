package simple;

import example.simple.Simple;
import example.simple.SimpleOuterClass;

import java.util.Arrays;

public class simpleMain {

    public static void main(String[] args) {
        Simple message = Simple.newBuilder()
                .setId(42)
                .setIsSimple(true)
                .setName("My Name")
                .addSimpleList(1)
                .addSimpleList(2)
                .addSimpleList(3)
                .addAllSimpleList(Arrays.asList(4, 5, 6))
                .build();

        System.out.println(message);
    }
}
