package com.test.datastructure;

import java.util.ArrayList;
import java.util.List;

//baoli
public class GenerateParantses22_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GenerateParantses22_1 test = new GenerateParantses22_1();
        System.out.println(test.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations, 0, 0);
        return combinations;
    }

    private void generateAll(char[] current, int pos, List<String> result, int leftCount, int rightCount) {
        if(pos == current.length) {
            result.add(new String(current));
            return;
        }
        if (leftCount < current.length / 2) {
            current[pos] = '(';
            generateAll(current, pos + 1, result, leftCount + 1, rightCount);
        }

        if (rightCount < leftCount) {
            current[pos] = ')';
            generateAll(current, pos + 1, result, leftCount, rightCount + 1);
        }

    }

}
