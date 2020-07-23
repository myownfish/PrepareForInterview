package com.test.datastructure;

import java.util.Arrays;

public class FriendCircles547_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FriendCircles547_1 test = new FriendCircles547_1();
        int[][] input = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println(test.findCircleNum(input));
    }

    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }

    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

}
