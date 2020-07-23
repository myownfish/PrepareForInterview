package com.test.datastructure;

public class MaxSubarray53 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        maxSubArray(nums);

    }

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int num : nums) {
             if(sum >= 0) {
                 sum = sum + num;
             }else {
                 sum = num;
             }
//            sum = sum + num;
//            if (sum < 0) {
//                sum = num;
//            }
//            result = Math.max(result, sum);

        }
        return result;
    }
}
