package com.test.goldmansachs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = { 5, 1, 9, 2, 8, 3, 7, 4, 6, 5, 9, 8, 2, 7, 3 };
        System.out.println(twoSum2(nums, 10));
    }

    public static int twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsSet = new HashMap<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (numsSet.get(find) != null && numsSet.get(find) != i) {
                String r = find < nums[i] ? find + ":" + nums[i] : nums[i] + ":" + find;
                result.add(r);
            } else {
                numsSet.put(nums[i], i);
            }
        }
        return result.size();
    }
}
