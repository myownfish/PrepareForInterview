package com.test.datastructure;

public class ProductSubarray152 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = { 2, -5, 0, -2, -4, 3 };
        maxProduct(nums);
    }
    
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
          for(int i=0; i<nums.length; i++){
              if(nums[i] < 0){ 
                int tmp = imax;
                imax = imin;
                imin = tmp;
              }
              imax = Math.max(imax*nums[i], nums[i]);
              imin = Math.min(imin*nums[i], nums[i]);
              
              max = Math.max(max, imax);
          }
          return max;
      }


    public static int maxProduct1(int[] nums) {

        int max = nums[0];
        int current = 1;

        for (int num : nums) {
            if (num == 0) {
                current = 1;
                max = Math.max(max, 0);
            } else {
                current = current * num;
                if (current < 0) {
                    current = num;
                }
                if (current > 0) {
                    max = Math.max(max, current);
                }

            }
        }

        return max;
    }

}
