package com.test.datastructure;

public class SumOfThreeNum {

    public static void main(String[] args) {
        // first step order asc
        int[] input = { -4, -1, -1, 0, 1, 2 };
        int[][] result;
        for (int i = 0; i < input.length; i++) {
            if (input[0] > 0) {
                break;
            }
            for (int j = input.length - 1; j >= 0; j--) {
                
                if (input[j] < 0) break;
                
                int sum = input[i] + input[j];
                if(sum == 0) {
                    //find if there is a 0 in the array
                    System.out.println(input[i] + "," + input[j]);
                    continue;
                }
                while (sum < 0) {
                    int b = input[j--];
                    if(b > 0) {
                        if(sum + b== 0) {
                            System.out.println(input[i] + "," + input[j]);
                            continue;
                        } 
                    }
                    
                }
                
            }
        }

    }

}
