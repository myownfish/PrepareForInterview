package com.test.stream;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lesson9LinkedHashMapSample {

    public static void main(String[] args) {

        LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75F,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3;
            }
        };
        accessOrderedMap.put("Project1", "Valhalla");
        accessOrderedMap.put("Project2", "Panama");
        accessOrderedMap.put("Project3", "Loom");
        accessOrderedMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project3");
        accessOrderedMap.get("Project1");

        accessOrderedMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

        accessOrderedMap.put("Project4", "Mission Control");
        accessOrderedMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

    }

}
