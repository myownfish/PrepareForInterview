package com.test.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder127 {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        WordLadder127 test = new WordLadder127();
        System.out.println(test.ladderLength(beginWord, endWord, wordList));

    }

    private int result = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, Set<String>> map = preprocess(wordList);
        Set<String> visited = new HashSet<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        queue.add(new Pair<String, Integer>(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String node = pair.getKey();
            visited.add(node);
            Integer level = pair.getValue();
            Set<String> nodes = preprocessWord(node);

            nodes.stream().forEach(wildCardNode -> {
                Set<String> set = map.getOrDefault(wildCardNode, new HashSet<>());
                    if (set.contains(endWord)) {
                        result = level + 1;
                        
                    } else {
                        set.stream().forEach(n -> {
                            if (!visited.contains(n)) {
                                queue.add(new Pair<String, Integer>(n, level + 1));
                            }
                        });
                    }
            });
            if(result != 0) {
                break;
            }
        }

        return result;
    }

    private Map<String, Set<String>> preprocess(List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        wordList.stream().forEach(word -> {
            Set<String> words = preprocessWord(word);
            words.stream().forEach(w -> {
                map.putIfAbsent(w, new HashSet<>());
                map.get(w).add(word);
            });
        });
        return map;
    }

    private Set<String> preprocessWord(String word) {
        Set<String> set = new HashSet<>();
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            char temp = wordChar[i];
            wordChar[i] = '*';
            set.add(new String(wordChar));
            wordChar[i] = temp;
        }
        return set;
    }

}
