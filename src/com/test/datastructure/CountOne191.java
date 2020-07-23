package com.test.datastructure;

public class CountOne191 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;

    }
    
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
                count++;
                n = n&(n-1);
        }
        return count;

    }
    
    public int hammingWeight2(int n) {
        int count = 0;
        int mask = 1;
//        while (n != 0) {
        for(int i = 0; i < 32;i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;

    }
}
