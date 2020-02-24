package com.test.goldmansachs;

public class PowerOfTen {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       System.out.println(isPowerOfTen(1));
       System.out.println(isPowerOfTen(10));
       System.out.println(isPowerOfTen(20000));
       System.out.println(isPowerOfTen(20010));
       System.out.println(isPowerOfTen(20001));
       System.out.println(isPowerOfTen(20100));
       System.out.println(isPowerOfTen(21000));
    }
    
    public static boolean isPowerOfTen(int num) {
        String numString = String.valueOf(num);
        if(numString.length() <2 ) {
            return false;
        }
        int numLenght = numString.length();
        
        int b = 1;
        while(numLenght > 1) {
            b = b * 10;
            numLenght--;
        }
        
        return num%b == 0;
    }
    
    public static boolean isPowerOfTen2(int num) {
        String numString = String.valueOf(num);
        if(numString.length() <2 ) {
            return false;
        }
        int numLenght = numString.length();
        
        System.out.println(numString.charAt(numLenght-1) + ":" + (int)numString.charAt(numLenght-1) +":"+ Integer.valueOf(numString.charAt(numLenght-1)));
        if(numString.charAt(numLenght-1) != '0') {
            return false;
        }
        return true;
        
    }

}
