package com.test.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Triangle120 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        triangle.add(a);
        triangle.add(Arrays.asList(3,4));
        triangle.add(Stream.of(5,6,7).collect(Collectors.toList()));
        triangle.add(Arrays.asList(4,1,8,3));
       System.out.println( minimumTotal2(triangle));
    }

    //bottom to top
    public static int minimumTotal(List<List<Integer>> triangle) {
        int i = triangle.size();
        List<Integer> res = triangle.get(i-1);
        for(int r = i - 2; r>=0; r--) {
            for(int c = 0; c < triangle.get(r).size(); c++) {
                int result = triangle.get(r).get(c) + Math.min(res.get(c), res.get(c+1));
                res.set(c, result);
            }
        }

        return res.get(0);
    }
    
  //top to bottom
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int i = triangle.size();
        for(int r = 1; r < triangle.size(); r ++) {
            for(int c = 0; c < triangle.get(r).size(); c++) {
                if(c ==0) {
                    int result = triangle.get(r).get(c) + triangle.get(r-1).get(c);
                    triangle.get(r).set(c, result);
                } else if(c == triangle.get(r).size() - 1) {

                    int result = triangle.get(r).get(c) + triangle.get(r-1).get(c-1);
                    triangle.get(r).set(c, result);
                
                
                }else {
                    int result = triangle.get(r).get(c) + Math.min(triangle.get(r-1).get(c), triangle.get(r-1).get(c-1));
                    triangle.get(r).set(c, result);
                }
                
            }
        }

         
        return triangle.get(triangle.size()-1).stream().mapToInt(v->v).min().getAsInt();
                
    }
}
