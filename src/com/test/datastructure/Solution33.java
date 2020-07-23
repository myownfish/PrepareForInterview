package com.test.datastructure;

import java.util.Arrays;

public class Solution33 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = { 4, 5, 6, 7, 0, 1, 2 };
        int rotatePoint = caculateRotatePoint(input);
        int target = 3;
        System.out.println(rotatePoint);
        if (rotatePoint + 1 < input.length && input[rotatePoint] > input[rotatePoint + 1]) {
            if (target < input[rotatePoint]) {
                System.out.println(search(input, target, rotatePoint, input.length - 1));
            } else {
                System.out.println(search(input, target, 0, rotatePoint));
            }
        } else {
            if (target < input[rotatePoint]) {
                System.out.println(search(input, target, 0, rotatePoint));
            } else {
                System.out.println(search(input, target, rotatePoint, input.length - 1));
            }
        }

//        System.out.println(search(input, 0));
    }

    private static int caculateRotatePoint(int[] input) {
        int result = -1;

        int left = 0;
        int right = input.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((mid + 1 < input.length && input[mid] > input[mid + 1]) || (mid - 1 >= 0 && input[mid] < input[mid - 1])) {
                return mid;
            }

            if (input[mid] < input[left]) {
                // rotate point in left
                right = mid - 1;
            } else if (input[mid] > input[right]) {
                // rotate point in right
                left = mid + 1;
            }
        }
        return result;
    }

    public static int search(int[] nums, int target, int start, int end) {
        int result = -1;

        int left = start;
        int right = end;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else {

                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }
}
