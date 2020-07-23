package com.test.datastructure;

public class LengthOfLastWorld58 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int lengthOfLastWord(String s) {
        int result = 0;
        if (s == null || s.trim().length() == 0) {
            return result;
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                if (result != 0) {
                    break;
                }
            } else {
                ++result;
            }
        }
        return result;
    }
}
