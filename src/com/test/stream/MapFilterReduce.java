package com.test.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapFilterReduce {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Person> list = new ArrayList<>();
        list.add(new Person("Kitty", 36));
        list.add(new Person("Chris", 35));
        list.add(new Person("Dan", 2));
        list.stream().forEach((p) -> System.out.println(p.toString()));// Consumer

        Predicate<Integer> age = t -> t > 20;
        Optional<Integer> sumOfAge = list.stream().map(p ->
         p.getAge()).filter(age).peek(System.out::println).reduce(Integer::sum);
        Optional<Integer> maxOfAge = list.stream().map(p ->
        p.getAge()).reduce(Integer::max);
        Optional<Integer> minOfAge = list.stream().map(p ->
        p.getAge()).reduce(Integer::min);
        System.out.println("sumOfAge is " + sumOfAge.get());
        System.out.println("maxOfAge is " + maxOfAge.get());
        System.out.println("minOfAge is " + minOfAge.get());
        Function<Integer, Integer> function1 = t -> t + 1;
        Function<Integer, Integer> function2 = t -> t * 2;
        Function<Integer, Integer> function3 = t -> t * 10;
        
         
        Function<Integer, Integer> function4 = function1.compose(function2);
        Function<Integer, Integer> function5 = function1.andThen(function2);
        
        
        list.stream().map(p ->p.getAge()).map(function4).forEach(System.out::println);
        list.stream().map(p ->p.getAge()).map(function5).forEach(System.out::println);
        list.stream().map(p ->p.getAge()).map(Function.identity()).forEach(System.out::println);
        
        List<Person> list1 = new ArrayList<Person>();
        list1.add(new Person("Kitty1", 36));
        list1.add(new Person("Chris1", 35));
        list1.add(new Person("Dan1", 2));
        List<Person> list2 = new ArrayList<Person>();
        list2.add(new Person("Kitty2", 36));
        list2.add(new Person("Chris2", 35));
        list2.add(new Person("Dan2", 2));
        List<List<Person>> personMap = new ArrayList<List<Person>>();
        personMap.add(list1);
        personMap.add(list2);
        System.out.println(personMap.size());
        System.out.println(personMap.get(0).size());

        System.out.println("FlatMap:");
        List<Person> result = new ArrayList<>();
        personMap.stream().flatMap(l -> l.stream()).peek(System.out::print).forEach(p->result.add(p));
        System.out.println(result.size());
        
        //Colltecting
        String nameList = list.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(nameList);
        
        
    }

}
