package com.test.datastructure;

public class Reverse190 {

    public static void main(String args[]) {
       System.out.println(reverseBits(4));
       System.out.println(reverseBits1(4));

    }
    
    public static int reverseBits(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i =0; i < 32; i ++) {
            builder.append( n & 1);
            n = n>>1;
        }
        return Integer.parseInt(builder.toString(), 2);
                
//                Byte.valueOf(builder.toString());
         
     }
    
   public static int reverseBits1(int n) {
       int ans = 0;
       for (int i =0; i < 32; i ++) {
           ans = (ans<<1) + (n & 1);
           n = n>> 1;
           
       }
       return ans;
        
    }
}
