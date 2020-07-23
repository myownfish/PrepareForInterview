package com.test.datastructure;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] input = { 10, 2, 5, 3, 7, 9, 4, 5, 8 };
        SelectionSort sort = new SelectionSort();
        sort.selectionSort(input);
        System.out.println(Arrays.toString(input));
    }

    public void selectionSort(int[] input) {

        for (int i = 0; i < input.length; i++) {
            int small = i;
            for (int j = i; j < input.length; j++) {//j = i + 1
                if (input[j] < input[small]) {
                    small = j;
                }
            }
            int temp = input[i];
            input[i] = input[small];
            input[small] = temp;
        }
    }
}
