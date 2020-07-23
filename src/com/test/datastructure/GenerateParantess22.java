package com.test.datastructure;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantess22 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateResult( n * 2, "", result, 0, 0);
        return result;
    }

    private static void generateResult(int length, String str, List<String> result, int left, int right) {
        // TODO Auto-generated method stub
        
        if (str.length() == length) {
            result.add(str);
        }
        if (left < length / 2) {
            generateResult(length, str + "(", result, left + 1, right);
        }
        if (right < left) {
            generateResult(length, str + ")", result, left, right + 1);

        }
    }

}
