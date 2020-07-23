package com.test.datastructure;

public class LongestValidParentheses32 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestValidParentheses32 check = new LongestValidParentheses32();
        //")()())()()("
        //()
        //"(()))())("
        //"(()(((()"
        System.out.println(check.longestValidParentheses("(()(((()"));
    }

    public int longestValidParentheses1(String s) {
        int temp = 0;
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                temp = temp + 2;
            } else if (s.charAt(i) == s.charAt(i - 1)) {
                result = Math.max(result, temp);
                temp = 0;
            }
        }
        return Math.max(result, temp);
    }

    public int longestValidParentheses(String s) {
        int result = 0;
        int temp = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                ++right;
                if (left < right) {
                    temp = Math.max(temp, left);
                    result = Math.max(temp, result);
                    right = 0;
                    left = 0;
                    temp = 0;
                } else if (left == right) {
                    temp += left;
                    result = Math.max(temp, result);
                    left = 0;
                    right = 0;
                    
                }
            } else {
                ++left;
            }

        }
        return Math.max(result, Math.min(left, right)) * 2;
    }

}
