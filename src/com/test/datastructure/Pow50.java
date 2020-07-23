package com.test.datastructure;

public class Pow50 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        myPow2(2, 10);
    }

    public static double myPow(double x, int n) {
        
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            n = -n;
            x = 1/x;
        }
        
        double result = myPow(x, n/2);
        if(n%2 == 0) {
            return result * result; 
        } else {
            return result * result * x;
        }

    }
    
    public static double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

}
