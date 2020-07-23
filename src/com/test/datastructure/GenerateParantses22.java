package com.test.datastructure;

import java.util.ArrayList;
import java.util.List;

//baoli
public class GenerateParantses22 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GenerateParantses22 test = new GenerateParantses22();
        System.out.println(test.generateParenthesis(3).size());
    }

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(')
                balance++;
            else
                balance--;
            if (balance < 0)
                return false;
        }
        return (balance == 0);
    }
}
