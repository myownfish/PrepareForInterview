package com.test.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SetSum40 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {10,1,2,7,6,1,5};
        combinationSum2(input,8);

    }
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

          Arrays.sort(candidates);
//        for(int i = 0; i < candidates.length; i++) {
            canculate(0, candidates, target, new LinkedList<>());
//        }
        return result;
    }

    private static void canculate(int i, int[] candidates, int target, LinkedList<Integer> linkedList) {
        // TODO Auto-generated method stub
        if (target == 0) {
            if(!result.contains(linkedList)) {
                result.add(new ArrayList<>(linkedList));
            }
            return;
        }
        if (target < 0) {
            return;
        }
        for(int j = i; j < candidates.length; j++) {
            
            linkedList.add(candidates[j]);
            canculate(j+1, candidates, target-candidates[j], linkedList);
            linkedList.removeLast();
        }
        
    }
}
