package com.test.datastructure;

import java.util.Arrays;

public class CountBits338 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        CountBits338 count = new CountBits338();
        System.out.println(Arrays.toString(count.countBits(5)));
    }
    
    public int[] countBits(int num) {
       int[] result = new int[num+1];
       for(int i = 0; i <=num; i++) {
           result[i] = countOne(i);
       }
       return result;
    }
    
    public int countOne(int num) {
        int result = 0;
        while(num != 0) {
            num = num & (num - 1);
            result++;
        }
        return result;
    }

}
