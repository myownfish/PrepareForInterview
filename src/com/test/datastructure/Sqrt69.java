package com.test.datastructure;

public class Sqrt69 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int input = 2147395599;
        int input2= 2147483647;
                    //1610546700
        long r = 536848901+1073697799;

        System.out.println(mySqrt(input));
    }
    
    public static int mySqrt(int x) {

        if(x < 2) return x;
        
        int left = 2;
        int right = x/2;
        while(left <= right) {
            //536848901:1073697799:1610546700

            long mid = (left + right)/2;
            System.out.println("mid:" + mid);
            long val = mid * mid;
            System.out.println("val:" + val);

            if(val == x) return (int)mid;
            else if(val > x) {
                right = (int)mid -1;
            } else {
                left = (int)mid + 1;
            }
        }
        return right;
    }

}
