package com.test.datastructure;

import java.util.ArrayList;
import java.util.List;

public class SubSet78 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {1,2,3};
        List<List<Integer>> result = subsets2(input);
        System.out.println(result);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<Integer>());
        for(int n: nums) {
            List<List<Integer>> subResult = new ArrayList<List<Integer>>();
            for(List<Integer> insideList: result) {
//                List<Integer> newInsideList = new ArrayList<>(insideList);
//                newInsideList.add(n);
                List<Integer> newInsideList = new ArrayList<Integer>(insideList) {
                    {
                    add(n);}
                    };
                subResult.add(newInsideList);
            }
            result.addAll(subResult);
        }

        
        return result;
    }

    private static void helper(int[] nums, int i, List<List<Integer>> result) {

        //ternimator
        if(i >= nums.length) {
            return;
        }
        
      //not include current number
        helper(nums, i+1, result);
        
        //process current logic
        //include current number
        if(result.get(i) == null) { 
            result.set(i, new ArrayList<Integer>());
        }
        result.get(i).add(nums[i]);
        
        
    }
    

    
    static int n = 0;
    static int k = 0;
    static List<List<Integer>> output = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsetsBackTrack(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
          backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
      }

    //回溯
    public static void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            output.add(new ArrayList<Integer>(curr));
            return;
        }
       
        
        for (int i = first; i < n; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
  //回溯2
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack2(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private static void backtrack2(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack2(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
