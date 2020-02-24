package com.test.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
Comparator c;
        int numToys = 6;
        int topToys = 2;
        List<String> toys = new ArrayList<>();
        toys.add("kitty");
        toys.add("chirs");
        toys.add("hello");
        toys.add("haha");
        
        int numQuotes = 4;
        List<String> quotes = new ArrayList<>();
        quotes.add("kitty kitty kitty");
        quotes.add("chirs chirs");
        quotes.add("hello  haha");
        quotes.add("haha");
        
        System.out.println(popularNToys(numToys, topToys, toys, numQuotes, quotes));
    }

    
     // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
     public static ArrayList<String> popularNToys(int numToys, 
                                           int topToys, 
                                           List<String> toys, 
                                           int numQuotes, 
                                           List<String> quotes)
     {
         Map<String, Integer> result = new HashMap<>();
         quotes.stream().forEach(quoteLine -> {
             Stream.of(quoteLine.split(" ")).forEach(quote ->
             {
             toys.stream().forEach(toy -> {
                 System.out.println(quote);
                 System.out.println(toy);
                 if(quote.contains(toy)) {
                     result.putIfAbsent(toy, 0);
                     result.put(toy, result.get(toy) + 1);
                 }
                 });
             });
         });
         result.forEach((key, value) -> System.out.println("There is " + value + " for "+ key));
         Map<String, Integer> r = result.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)-> e1, LinkedHashMap::new));
         
         List<String> list = new ArrayList<String>(r.keySet());
         return new ArrayList<String>(list.subList(0, topToys));
        
         // WRITE YOUR CODE HERE
     }
     // METHOD SIGNATURE ENDS
 
}
