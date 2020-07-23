package com.test.datastructure;

import java.util.Arrays;

public class Solution33_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {8,9,1,3,4};
        int target = 1;


        System.out.println(search(input, target));
    }

    private static int caculateRotatePoint(int[] input) {
        int result = 0;
        
        int left = 0;
        int right = input.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid + 1 < input.length && input[mid] > input[mid + 1]) {
                return mid +1;
            } else if(mid - 1 >= 0 && input[mid] < input[mid - 1]) {
                return mid;
            }

            if (input[mid] < input[left]) {
                // rotate point in left
                right = mid - 1;
            } else if (input[mid] > input[right]) {
                // rotate point in right
                left = mid + 1;
            } else {
                return result;
            }
        }
        return result;
    }

    public static int search(int[] input, int target) {
        
        if(input == null || input.length ==0) {
            return -1;
        }
        if(input.length == 1) {
            return input[0] == target ? 0 : -1;
        }
//        if(input.length == 2) {
//            if(input[0] == target) return 0;
//            if(input[1] ==target) return 1;
//            return -1;
//        }
        
        int rotatePoint = caculateRotatePoint(input);
        System.out.println(rotatePoint);
        if(rotatePoint == 0) {
            return search(input, target, 0, input.length - 1);
        } else if(rotatePoint == input.length-1) {
            if(target == input[rotatePoint]) return rotatePoint;
            return search(input, target, 0, rotatePoint-1);
        } else if(target <= input[input.length-1]) {
            return search(input, target, rotatePoint, input.length - 1);
        } else {
            return search(input, target, 0, rotatePoint - 1);
        }
    }

    private static int search(int[] nums, int target, int start, int end) {
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
