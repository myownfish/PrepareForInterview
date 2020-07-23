package com.test.datastructure;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SetSum39 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {8,7,4,3};
        List<List<Integer>> result = combinationSum(input, 11);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for (int i : candidates) {
            if(i < target) {
                int count = target/i;
                while(count > 0) {
                    input.add(i);
                    --count;
                }
            } else {
                input.add(i);
            }

        }

        backtrack2(0, input, res, new ArrayList<Integer>(), target);
        return res;
    }

    private static void backtrack2(int i, List<Integer> nums, List<List<Integer>> res, ArrayList<Integer> tmp, int target) {
        int sum = tmp.stream().mapToInt(val -> val.intValue()).sum();
        if (sum > target) {
            return;
        }
        if (sum == target) {
            if (!res.contains(tmp)) {
                res.add(new ArrayList<>(tmp));
            }
            // add to final result
            return;
        }

        for (int j = i; j < nums.size(); j++) {
            tmp.add(nums.get(j));
            backtrack2(j + 1, nums, res, tmp, target);
            if (tmp.size() - 1 < 0) {
                tmp.remove(tmp.size());
            } else {
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates, target, new LinkedList<>(), res);
        return res;
    }
    
    private static void backtrack(int start, int[] candidates, int target, LinkedList<Integer> track, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] > target) {
                continue;
            }
            track.add(candidates[i]);
            backtrack(i, candidates,target - candidates[i], track, res);
            track.removeLast();
        }
        
        

    }

}
