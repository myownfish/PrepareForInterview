package com.test.datastructure;

import java.util.Arrays;

public class IslandNum200_UnionFind {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        IslandNum200_UnionFind test = new IslandNum200_UnionFind();
      System.out.println(test.numIslands(grid));
    }
    
    public  int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = m * n;
        int[] parent = new int[count];
        Arrays.fill(parent, -1);
        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                  //坐标转换
                    int current = i * n + j;

                    if(j > 0 && grid[i][j-1] == '1') { //left
                        int left = i * n + j - 1;
                        union(current, left, parent);
                    }
                    if(j < n - 1 && grid[i][j+1] == '1') { //right
                        int right = i * n + j + 1;
                        union(current, right, parent);
                    }
                    
                    if(i > 0 && grid[i-1][j] == '1') { //up
                        int up = (i -1) * n + j; 
                        union(current, up, parent);
                    }
                    if(i < m - 1 && grid[i+1][j] == '1') { //down
                        int down = (i +1) * n + j;
                        union(current, down, parent);
                    }
                } else {
                    parent[i * n + j] = -2;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < parent.length; i ++) {
            if(parent[i] == -1) {
                result ++;
            }
        }
        return result;
    }

    public int find(int p, int[] parent) {
        if(parent[p] == -1) {
            return p;
        }
        return find(parent[p], parent);//??
    }
    
    public void union(int p, int q, int[] parent) {
        int rootP = find(p, parent);
        int rootQ = find(q, parent);
        if(rootP == rootQ)
            return;
        parent[rootP] = rootQ;
    }

}
