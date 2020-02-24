package com.test.datastructure;

import java.util.Arrays;

public class MoveZero {

    public static void main(String[] args) {
        int[] array = { 0, 1, 0, 3, 12 };
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] != 0) {
                array[i] = array[j];
                if(i != j) {
                    array[j] = 0;
                }
                i++;
            }

        }

        Arrays.stream(array).forEach(System.out::println);
    }

}
