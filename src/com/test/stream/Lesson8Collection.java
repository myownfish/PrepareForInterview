package com.test.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Lesson8Collection {

    public static void main(String[] args) {

        Vector<String> v;
        ArrayList<String> al;
        LinkedList<String> ll;
//        HashSet<String> set = new HashSet<>();
//        set.add("轷龚");
//        set.add("轸齻");
//        System.out.println(set.size());
        HashMap<String, String> set = new HashMap<>();
        set.put("轷龚", "first");
        set.put("轸齻", "second");
        set.put("轸齻", "nihao");

        set.put("1", "haha");
//        set.add("ehllo");
        System.out.println(set.size());
        System.out.println(set.get("轷龚"));
        System.out.println(set.get("轸齻"));
        System.out.println(set.get("1"));
        Set<Entry<String, String>> set2 = set.entrySet();
        
        TreeSet<String> treeSet = new TreeSet<>();


    }

}
