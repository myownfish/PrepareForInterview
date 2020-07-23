package com.test.datastructure;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] input = { 10, 2, 5, 3, 7, 9, 4, 5, 8 };
        MergeSort sort = new MergeSort();
        int[] result = sort.mergeSort(input);
        System.out.println(Arrays.toString(result));

    }

    public int[] mergeSort(int[] input) {
        //teminator
        if (input.length < 2) {
            return input;
        }
        //logic for current level
        int middle = (int) Math.floor(input.length / 2); //    int mid = (left + right) >> 1; // (left + right) / 2
        int[] left = Arrays.copyOfRange(input, 0, middle);
        int[] right = Arrays.copyOfRange(input, middle, input.length);
        //drill down
        int[] resultLeft = mergeSort(left);
        int[] resultRight = mergeSort(right);
        //generate the result
        return merge(resultLeft, resultRight);
    }

    private int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] result = new int[leftLength + rightLength];

        int li = 0;
        int ri = 0;
        int i = 0;
        while (li < leftLength && ri < rightLength) {
            if (left[li] < right[ri]) {
                result[i++] = left[li++];
            } else {
                result[i++] = right[ri++];
            }
        }
        while(li < leftLength) {
            result[i++] = left[li++];
        }
        while(ri < rightLength) {
            result[i++] = right[ri++];
        }
        return result;
    }
}
