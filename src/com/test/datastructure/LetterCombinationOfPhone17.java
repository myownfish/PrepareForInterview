package com.test.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhone17 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(letterCombinations("2"));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<String>();
        if (digits == null || digits.trim().length() == 0) {
            return result;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        String a = map.get(digits.charAt(0));
        String b = digits.length() == 1? null : map.get(digits.charAt(1));
        if (a == null && b == null)
            return result;
        generateResult(a, b, result);

        return result;
    }

    private static void generateResult(String a, String b, List<String> result) {
        char[] single = null;
        if (a != null && b == null) {
            single = a.toCharArray();
        } else if (a == null && b != null) {
            single = b.toCharArray();
        }
        if (single != null) {
            for (char c : single) {
                result.add(String.valueOf(c));
            }
           
        } else {
            char[] arrayA = a.toCharArray();
            char[] arrayB = b.toCharArray();

            for (char charA : arrayA) {
                for (char charB : arrayB) {
                    result.add(String.valueOf(charA) + String.valueOf(charB));
                }
            }
        }
        
    }

}
