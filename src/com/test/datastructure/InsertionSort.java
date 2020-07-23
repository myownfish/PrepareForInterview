package com.test.datastructure;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {10,2,5,3,7,9,4,5,8};
        InsertionSort sort = new InsertionSort();
        sort.insertionSort(input);
        System.out.println(Arrays.toString(input));
    }
    
    public void insertionSort1(int[] input) {
        for(int i = 0; i < input.length - 1; i++) {
            for(int j = i + 1; j > 0; j--) {
                if(input[j] < input[j - 1]) {
                    int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
    }
    
    public void insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for(int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while(preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

}
