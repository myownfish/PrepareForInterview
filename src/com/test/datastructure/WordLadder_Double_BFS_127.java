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

public class WordLadder_Double_BFS_127 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));

        WordLadder_Double_BFS_127 check = new WordLadder_Double_BFS_127();
        System.out.println(check.ladderLength(beginWord, endWord, wordList));
    }

    int result = 0;
    Queue<Pair<String, Integer>> queue1 = new LinkedList<>();
    Queue<Pair<String, Integer>> queue2 = new LinkedList<>();
    Map<String, Integer> visited1 = new HashMap<>();
    Map<String, Integer> visited2 = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return result;
        }

        Map<String, Set<String>> mapForPatterns = new HashMap<String, Set<String>>();
        Map<String, Set<String>> mapForWords = new HashMap<String, Set<String>>();
        preprocess(wordList, mapForPatterns, mapForWords);
        mapForWords.put(beginWord, getAllPattern(beginWord));
        queue1.add(new Pair(beginWord, 1));
        queue2.add(new Pair(endWord, 1));
        visited1.put(beginWord, 1);
        visited2.put(endWord, 1);
        while (!queue1.isEmpty()) {
            Pair<String, Integer> pair = queue1.poll();
            String word = pair.getKey();
            Integer level = pair.getValue();
            Set<String> patterns = mapForWords.get(word);
            for (String pattern : patterns) {
                Set<String> words = mapForPatterns.getOrDefault(pattern, new HashSet<>());
                for(String w :words) {
                    if (visited2.containsKey(w)) {
                        // now it is over
                        result = level + visited2.get(w);
                        return result;
                        
                    }
                    if (!visited1.containsKey(w)) {
                        queue1.add(new Pair<>(w, level + 1));
                        visited1.put(w, level + 1);
                    }
                }
                if(result > 0) {
                    break;
                }
            }
            if (queue1.size() > queue2.size()) {
                Queue<Pair<String, Integer>> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                Map<String, Integer> tempSet = visited1;
                visited1 = visited2;
                visited2 = tempSet;
            } 
            if(result > 0) {
                break;
            }
        }

        return result;
    }

   

    private void preprocess(List<String> wordList, Map<String, Set<String>> mapForPatterns, Map<String, Set<String>> mapForWords) {
        // TODO Auto-generated method stub
        wordList.stream().forEach(word -> {
            Set<String> patterns = getAllPattern(word);
            mapForWords.put(word, patterns);
            patterns.stream().forEach(pattern -> {
                Set<String> p = mapForPatterns.getOrDefault(pattern, new HashSet<>());
                p.add(word);
                mapForPatterns.put(pattern, p);
            });

        });
    }

    private Set<String> getAllPattern(String word) {
        // TODO Auto-generated method stub
        Set<String> patterns = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            String pattern = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
            patterns.add(pattern);
        }
        return patterns;
    }

}
