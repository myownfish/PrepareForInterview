package com.test.stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

class Indices {
    public String s;
    public List<Integer> indices;
    public Indices(String s) {
        this.s=s;
        indices= new LinkedList<>();
        for (int i=0;i<this.s.length();++i) {
            indices.add(i);
        }
    }
}
class TestIndices {
    public static void main(String[] args){
        Stream.of(new Indices("Mercury"),new Indices("Venus"),new Indices("Earth"))
              .flatMap( i -> i.indices.stream())
              .mapToInt(j -> j)
              .max()
              .ifPresent(s -> System.out.println(s));
        
        
        List<Integer> list=new ArrayList<>();
                   for(int i=1;i<=3;i++)
                         list.add(i);
                         Spliterator<Integer> split = list.spliterator();
                         split.forEachRemaining(z -> System.out.print(z + " ")); 
    }   
}
