package com.test.datastructure;

import java.util.Arrays;

public class DifferentPath62 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(uniquePaths3(6,4));
    }
        public static int result;
        public static int uniquePaths(int m, int n) {
          helper(1, 1, m, n);
          return result; 
        }

        public static void helper(int currentM, int currentN, int m, int n) {
            if(currentM > m || currentM < 1){
                return;
            } else if(currentN > n || currentN < 1){
                return;
            }
            if( currentN == n && currentM == m){
                result++;
            }
            helper(currentM+1, currentN, m, n);
            helper(currentM, currentN+1, m, n);

        }
        
        public static int uniquePaths1(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) dp[0][i] = 1;
            for (int i = 0; i < m; i++) dp[i][0] = 1;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];  
        }
        
        public static int uniquePaths2(int m, int n) {
            int[][] array = new int[m][n];
            for(int i = 0; i < n; i++){
                array[0][i] = 1;
            }
            for(int j = 0; j < m; j++) {
                array[j][0] = 1;
            }

            for(int p=1; p<m; p++){
                for(int q = 1; q < n; q++){
                    array[p][q] = array[p-1][q] + array[p][q-1];
                }
            }
            return array[m-1][n-1]; 
        }
        
        public static int uniquePaths3(int m, int n) {
            int[] pre = new int[n];
            int[] cur = new int[n];
            Arrays.fill(pre, 1);
            Arrays.fill(cur, 1);
            for(int i = 1; i < m; i++) {
                for(int j = 1; j < n; j++) {
                    cur[j] = cur[j - 1] + pre[j];
                }
                pre = cur.clone();
            }
            
            return cur[n-1];

        }



}
