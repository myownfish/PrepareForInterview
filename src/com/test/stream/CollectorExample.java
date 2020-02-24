package com.test.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Person> persons = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(CollectorExample.class.getResourceAsStream("people.txt")));
                Stream<String> stream = reader.lines();){
            stream.map(line ->{
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                persons.add(p);
                return p.getName();
            }).forEach(System.out::println);
            
            Stream<Person> personStream = persons.stream();
            Optional<Person> age = personStream.filter(p -> p.getAge() > 5).min(Comparator.comparing(Person::getAge));
            System.out.println(age.get());
            
            Map<Integer, Long> map = persons.stream().collect(
                    Collectors.groupingBy(Person::getAge, Collectors.counting()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
