package com.test.datastructure;

import java.util.Arrays;

public class QuickSort1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = { 10, 2, 5, 3, 7, 9, 4, 5, 8 };

        QuickSort1.quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));

    }
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }

}
