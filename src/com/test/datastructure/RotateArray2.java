package com.test.datastructure;

public class RotateArray2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {-1};
        int step = 2;
        rotate(nums, step);
        System.out.println(nums);
    }

    
    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int toIndex = i + k;
            if(toIndex >= nums.length) {
                toIndex = toIndex - nums.length;
            }
            if(toIndex >= result.length) {
                break;
            }
            result[toIndex] = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}
