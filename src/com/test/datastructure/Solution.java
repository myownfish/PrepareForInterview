package com.test.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public static void main(String[] args) {
      System.out.println(fib(5));
    }
    
    public static int fib(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        if(N == 2) return 1;
        Map<Integer, Integer> subResult = new HashMap<Integer, Integer>();
        subResult.put(0,0);
        subResult.put(1,1);
        subResult.put(2,1);
        for(int i = 3; i <= N; i++) {
            helper(N, i, subResult);
        }
        return subResult.get(N);

    }
    
    public static void helper(int N, int current, Map<Integer, Integer> midResult) {
         Integer currentVal = midResult.get(current - 1) + midResult.get(current - 2);
         midResult.put(current, currentVal);
    }
    
    
    
    
    
    /*
     * class Solution {
    public int fib(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        if(N == 2) return 1;
        Map<Integer, Integer> subResult = new HashMap<Integer, Integer>();
        subResult.put(0,0);
        subResult.put(1,1);
        subResult.put(2,1);
        return helper(N, 3, subResult);

    }
    
    public int helper(int N, int current, Map<Integer, Integer> midResult) {
         Integer currentVal = midResult.get(current - 1) + midResult.get(current - 2);
         midResult.put(current, currentVal);
         if(N > current){
             helper(N, current+1, midResult);
         }
        return currentVal;
    }
}
     */
}
