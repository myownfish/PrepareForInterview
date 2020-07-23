package com.test.datastructure;

import java.util.Arrays;

public class DifferentPath63 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int[][] input = {{0, 0,0},{0,1,0},{0,0,0}};
        int[][] input = {{}};

        System.out.println(uniquePathsWithObstacles(input));
    }
 
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length ==0) return 0;
        if(obstacleGrid[0] == null || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        
        int[] curRow = new int[n];
        for( int i = 0; i < n ; i++) {
            if(obstacleGrid[0][i] ==1 || (i > 0 && curRow[i -1] == 0)) {
                curRow[i] = 0;
            } else {
                curRow[i] = 1;
            }
        }
        
        for(int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] == 1 || curRow[0] == 0) {
                curRow[0] = 0;
            } else {
                curRow[0] = 1;
            }
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    curRow[j] = 0;
                } else {
                    curRow[j] = curRow[j] + curRow[j - 1];
                }
            }
        }
        return curRow[n-1];
    }
}
