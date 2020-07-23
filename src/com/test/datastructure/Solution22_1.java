package com.test.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Solution22_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        generateParenthesis(5);
    }

        public static List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c)
                    for (String left: generateParenthesis(c))
                        for (String right: generateParenthesis(n-1-c))
                            ans.add("(" + left + ")" + right);
            }
            return ans;
        }
    
}