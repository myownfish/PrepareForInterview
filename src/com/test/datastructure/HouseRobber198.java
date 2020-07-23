package com.test.datastructure;

public class HouseRobber198 {
//DP: f(n) = max(f(n-2), f(n-3)) + num[n];
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[1], nums[0] + nums[2]);
        }

         int[] result = new int[nums.length];
         result[0] = nums[0];
         result[1] = nums[1];
         result[2] = result[0] + nums[2];
         for (int i = 3; i < nums.length; i++) {
         result[i] = Math.max(result[i-2], result[i-3]) + nums[i];
         }
       
        return Math.max(result[result.length-1], result[result.length-2]);
    }



    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[1], nums[0] + nums[2]);
        }

        int[] result = new int[3];
        result[0] = nums[0];
        result[1] = nums[1];
        result[2] = result[0] + nums[2];
        int subResult = 0;
        for (int i = 3; i < nums.length; i++) {
            subResult = Math.max(result[0], result[1]) + nums[i];
            result[0] = result[1];
            result[1] = result[2];
            result[2] = subResult;
        }
        return Math.max(result[1], result[2]);
    }


}
