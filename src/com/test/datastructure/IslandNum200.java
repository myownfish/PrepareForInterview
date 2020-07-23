package com.test.datastructure;

public class IslandNum200 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
      System.out.println(numIslands(grid));
    }
    
    public static int numIslands(char[][] grid) {

        int result = 0;
        int n = grid.length;
        if(n == 0) return result;
        int m = grid[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    
                    mark(i,j, grid, n, m);
                    result++;
                }
            }
        }
        
        return result;

    }

    private static void mark(int i, int j, char[][] grid, int n, int m) {

        if(i>= n || j >= m || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        mark(i+1,j, grid, n, m);
        mark(i, j+1, grid, n , m);
    }

}
