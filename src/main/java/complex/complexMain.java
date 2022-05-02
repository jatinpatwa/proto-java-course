package complex;

import example.complex.ComplexOuterClass;

import java.util.Arrays;

public class complexMain {
    private static ComplexOuterClass.Dummy newDummy(int id, String name) {
        return ComplexOuterClass.Dummy.newBuilder()
                .setId(id)
                .setName(name)
                .build();
    }

    public static void main(String[] args) {
        ComplexOuterClass.Complex message = ComplexOuterClass.Complex.newBuilder()
                .setDummyOne(newDummy(55, "One Dummy"))
                .addAllDummies(
                        Arrays.asList(
                                newDummy(66, "Two Dummy"),
                                newDummy(56, "Three Dummy"),
                                newDummy(77, "Four Dummy")
                        )
                ).build();

        System.out.println(message);
    }
}
