package com.test.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Others {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(String.join(",", "12","23"));
        String s = "hello world!";
        s.chars().mapToObj(i -> (char)i).forEach(i-> System.out.print(Character.toUpperCase(i)));
        
        StringJoiner sj = new StringJoiner(",","{","}");
        sj.add("hello");
        sj.add("world");
        System.out.println(sj.toString());
        
        Path path = Paths.get("/Users/chris");
        try(Stream<Path> stream = Files.list(path)){
            stream.filter(p -> p.toFile().isDirectory()).forEach(System.out::println);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Comparator c;
    }

}
