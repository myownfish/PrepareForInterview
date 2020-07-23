package com.test.datastructure;

import java.util.ArrayList;
import java.util.List;

public class WordSearch212 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        String[] words = { "oath", "pea", "eat", "rain" };
        WordSearch212 root = new WordSearch212();
        System.out.println(root.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie root = new Trie();
        for (String s : words) {
            root.insert(s);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, new StringBuilder(), result, new boolean[board.length][board[0].length]);
            }
        }
        return result;
    }

    private void dfs(char[][] board, Trie root, int rowNum, int cellNum, StringBuilder builder, List<String> result, boolean[][] visited) {
        // TODO Auto-generated method stub
        if (rowNum >= board.length || cellNum >= board[0].length || rowNum < 0 || cellNum < 0 || visited[rowNum][cellNum] == true) {
            return;
        }
        builder.append(board[rowNum][cellNum]);
        visited[rowNum][cellNum] = true;
        if (!root.startsWith(builder.toString())) {
//            visited[rowNum][cellNum] = false;
            builder.deleteCharAt(builder.length() - 1);
            return;
        }

        if (root.search(builder.toString())) {
            result.add(builder.toString());
            return;
        }
        dfs(board, root, rowNum, cellNum+1, builder, result, visited);
        dfs(board, root, rowNum+1, cellNum, builder, result, visited);
        dfs(board, root, rowNum, cellNum-1, builder, result, visited);
        dfs(board, root, rowNum-1, cellNum, builder, result, visited);

    }

//    private List<String> dfs(){
//        StringBuilder builder = new StringBuilder();
//        

}
