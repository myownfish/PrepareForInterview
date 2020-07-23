package com.test.datastructure;

import java.util.HashMap;
import java.util.HashSet;

public class JewelsAndStones771 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int numJewelsInStones(String J, String S) {
        int result = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    result++;
                }
            }
        }
        return result;

    }

    public int numJewelsInStonesUsingHash(String J, String S) {
        HashSet<Character> set = new HashSet<>();

        int result = 0;
        for (int j = 0; j < J.length(); j++) {
            set.add(J.charAt(j));
        }
        for (int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;

    }
}
