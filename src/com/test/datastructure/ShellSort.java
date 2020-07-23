package com.test.datastructure;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] input = { 10, 2, 5, 3, 7, 9, 4, 5, 8 };
        ShellSort sort = new ShellSort();
        sort.shellSort(input);
        System.out.println(Arrays.toString(input));

    }

    public void shellSort1(int[] input) {
        for (int k = 3; k > 0; k--) {
            for (int j = 0; j < input.length - k; j++) {
                if (input[j] > input[j + k]) {
                    int temp = input[j];
                    input[j] = input[j + k];
                    input[j + k] = temp;
                }
            }
        }
    }
    
    public void shellSort(int[] arr) {
        int len = arr.length;
        for(int gap = (int)Math.floor(len / 2); gap > 0; gap = (int)Math.floor(gap / 2)) {
            for(int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while(j - gap >= 0 && current < arr[j - gap]) {
                     arr[j] = arr[j - gap];
                     j = j - gap;
                }
                arr[j] = current;
            }
        }
    }

}
