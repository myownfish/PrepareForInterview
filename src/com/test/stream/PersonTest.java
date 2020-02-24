package com.test.stream;

import java.util.Arrays;
import java.util.List;

class Persons {
    String name;
    Integer id;
    Persons(String n, Integer i) { name=n; id=i; }
    Persons(Integer i) {name=null; id=i;}
    @Override public String toString() { return name + " " + id; }
}
public class PersonTest {
    static List<Persons> people = Arrays.asList(
              new Persons("Bob",1),new Persons(2),new Persons("Jane",3));
    static int x;
    public static void main(String[] args) {               
        people.stream()
              .reduce((e1,e2) -> { x=e1.id; if (e1.id > e2.id) return e1; x=e2.id; return e2;})
              .flatMap(e -> Optional.ofNullable(e.name))
//              .map(y -> new Persons(y,x))
              .ifPresent(System.out::println);
    }
}


//23280666958242