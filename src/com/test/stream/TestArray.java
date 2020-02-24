package com.test.stream;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray {

    public static void main(String[] args) {
        String[] a = new String[10];
        a[0] = "hello";
        a[1] = "world";
        Arrays.stream(a).forEach(s -> {
            System.out.print(s);
            System.out.print(",");
        });
        System.out.println();
        a[0] = null;
        Arrays.stream(a).forEach(s -> {
            System.out.print(s);
            System.out.print(",");
        });
        System.out.println();
    }

}
