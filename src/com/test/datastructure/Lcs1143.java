package com.test.datastructure;

public class Lcs1143 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(longestCommonSubsequence("lcnqdmvsdopkvqvejijcdyxetuzonuhuzkpelmva"
                ,"bklgfivmpozinybwlovcnafqfybodkhabyrglsnen"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1.trim().length() == 0) {
            return 0;
        }
        if(text2 == null || text2.trim().length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int row = i == 0 ? 0 : i - 1;
                int cel = j == 0 ? 0 : j - 1;
                if (text1.charAt(i) == text2.charAt(j)) {
                    if(i == 0 || j ==0) {
                        result[i][j] = 1;
                    }else {
                        result[i][j] = result[row][cel] + 1;

                    }
                } else {
                    
                    result[i][j] = Math.max(result[row][j], result[i][cel]);
                }
            }
        }

        return result[m-1][n-1];
    }

}
