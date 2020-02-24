package com.test.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingMaps {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub

        List<Person> list = new ArrayList<Person>();
        Path p = Paths.get("/Users/chris/Documents/workspace-sts/TestJava8/src/com/test/stream/people.txt");
        
        try( Stream<String> s = Files.lines(p)){
            s.forEach(
                        line ->{
                             String[] l = line.split(" ");
                             Person person = new Person(l[0], Integer.valueOf(l[1]));
                             list.add(person);
                    });
                } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        list.forEach(System.out::println);
            
        List<Person> list1 = list.subList(0, 3);
        List<Person> list2 = list.subList(3, list.size());
        
        Map<Integer, List<Person>> map1 = mapByAge(list1);
        Map<Integer, List<Person>> map2 = mapByAge(list2);
        map1.forEach((age, listOfPerson)->{
            System.out.println(age + " -> " + listOfPerson);
        });
        map2.forEach((age, listOfPerson)->{
            System.out.println(age + " -> " + listOfPerson);
        });
    
        map2.entrySet().stream().forEach(
                entry -> map1.merge(
                        entry.getKey(), 
                        entry.getValue(), 
                        (l1, l2) -> {l1.addAll(l2);
                        return l1;}));
        System.out.println("Merged:");
        map1.forEach((age, listOfPerson)->{
            System.out.println(age + " -> " + listOfPerson);
        });
        
        //construct bitmaps
        
    }
    
    private static Map<Integer, List<Person>> mapByAge(List<Person> list) {
        Map<Integer, List<Person>> personMap = list.stream().collect(
                Collectors.groupingBy(Person::getAge));
        return personMap;
        
    }

}
