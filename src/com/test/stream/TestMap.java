package com.test.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TestMap {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Map<String, Person> map = new HashMap<String, Person>();
        Path p = Paths.get("/Users/chris/Documents/workspace-sts/TestJava8/src/com/test/stream/");
        
        try( Stream<Path> s = Files.list(p)){
            s.filter(path-> path.toFile().getName().endsWith("people.txt"))
//            .forEach(path-> System.out.println(path.toFile().getName()));
            .forEach(path->{
                try {
                     Files.lines(path).forEach(
                        line ->{
                             String[] l = line.split(" ");
                             Person person = new Person(l[0], Integer.valueOf(l[1]));
                             map.put(person.getName(), person);
                    });
                } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }});
//            s.forEach(line ->{
//                String[] l = line.split(" ");
//                Person person = new Person(l[0], Integer.valueOf(l[1]));
//                map.put(person.getName(), person);
//            });
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        map.forEach((k, v)-> System.out.println(v));
//        map.getOrDefault(key, defaultValue);
//        map.putIfAbsent(key, value);
//        map.replace(key, value);
        
        
        
    }

}
