package com.test.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class TwoSum1 {
    
    
    public static void main(String[] args) {
        int[] array = {3, 3};
        int[] result = twoSum2(array, 6);
        System.out.println(result);
    }
    
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numsSet = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numsSet.put(nums[i], i);

        }
        
        
        for(int i = 0; i< nums.length; i++) {
            int find = target - nums[i];
            if(numsSet.get(find) != null && numsSet.get(find) != i) {
               result[0] = i;
               result[1] = numsSet.get(find);
               return result;
            }
        }
        return null;
    }
    
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numsSet = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            
            int find = target - nums[i];
            if(numsSet.get(find) != null && numsSet.get(find) != i) {
                result[0] = i;
                result[1] = numsSet.get(find);
                return result;
             }
            numsSet.put(nums[i], i);
        }
        
        return null;
    }


}
