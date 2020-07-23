package com.test.datastructure;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] input = { 10, 2, 5, 3, 7, 9, 4, 5, 8 };

        QuickSort.quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));

    }

    public static void quickSort(int[] input, int start, int end) {
        if(start < 0 || input == null || input.length == 0 || end <= start) {
            return;
        }
        int pivot = start;
        int swap = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (input[i] < input[pivot]) {
                int temp = input[i];
                input[i] = input[swap];
                input[swap++] = temp;
            }
        }
        int temp = input[pivot];
        input[pivot] = input[swap - 1];
        input[swap - 1] = temp;
        
        quickSort(input, pivot, swap - 1);
        quickSort(input, swap, end);
    }

}
