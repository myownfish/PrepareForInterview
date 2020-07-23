package com.test.datastructure;

public class Trie {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[] input = { "trie", "insert", "search", "search", "startsWith", "insert", "search" };
        Trie root = new Trie();
        for (String s : input) {
            root.insert(s);
        }

    }

    private Trie[] links;
    private final int R = 26;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        links = new Trie[R];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            if (root.links[word.charAt(i) - 'a'] == null) {
                root.links[word.charAt(i) - 'a'] = new Trie();
            } 
                root = root.links[word.charAt(i) - 'a'];
            
        }
        root.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    private Trie searchPrefix(String word) {
        Trie currentNode = this;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (currentNode.links[curLetter - 'a'] != null) {
                currentNode = currentNode.links[curLetter - 'a'];
            } else {
                return null;
            }
        }
        return currentNode;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        Trie node = searchPrefix(prefix);
        return node != null;
    }

    /**
     * Your Trie object will be instantiated and called as such: Trie obj = new
     * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
     * = obj.startsWith(prefix);
     */

}
