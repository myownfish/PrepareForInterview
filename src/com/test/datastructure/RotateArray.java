package com.test.datastructure;

public class RotateArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1,2, 3, 4 ,5, 6};
        int step = 4;
        rotate(nums, step);
        System.out.println(nums);
    }

    
    public static void rotate(int[] nums, int k) {
        int step = 0;
        if(nums.length ==1 || k == 0) {
            return;
        }
        if(nums.length<k) {
            step = k%nums.length;
            if(step ==0) {
                return;
            }
        } else if(nums.length == k) {
            return;
        } else {
            step = k;
        }
        int startPointNum = 0 ;
        if(nums.length%step == 0) {
            startPointNum = step - 1;
            if(startPointNum == 0) startPointNum++;
            
        }
        if(nums.length ==2 && k==1) {
            startPointNum = 0;
        }
        if(step == 1) {
            startPointNum = 0;
        }
        
        int toIndex = 0;
        int from;
        int to = 0;
        for (int i = 0; i <= startPointNum; i++) {
            toIndex = i;
            
            do {
                if(toIndex == i) {
                    from = nums[toIndex];
                } else {
                    from = to;
                }
                toIndex = toIndex + step;
                if(toIndex >= nums.length) {
                    toIndex = toIndex - nums.length;
                }
                to = nums[toIndex];
                
                nums[toIndex] = from;
                
            }while(toIndex != i);
        }
    }
}
