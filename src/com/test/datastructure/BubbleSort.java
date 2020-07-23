package com.test.datastructure;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {10,2,5,3,7,9,4,5,8};
        System.out.println(Arrays.toString(input));

        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(input);
        System.out.println(Arrays.toString(input));
    }
    
    public void bubbleSort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {
            for(int j = 0; j < len - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {        // 相邻元素两两对比
                    int temp = arr[j+1];        // 元素交换
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public void bubbleSort1(int[] input) {
        int length = input.length;
        int i = length - 1;
        int j = 0;
        while(i >= 0) {
            while (j < i) {
                if(input[j] > input[j+1]) {
                    int temp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                }
                ++j;
            }
            --i;
            j = 0;//don't for reset j to 0
        }
    }
    
    public void bubbleSort2(int[] input) {
        int length = input.length;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                }
            }
        } 
 
    }
    
}
