package com.test.stream;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Lesson4TestReference {

    public static void main(String[] args) {

        System.out.println("Start");
        List<String> a = new ArrayList<>(100000000);

        SoftReference<List<String>> sr = new SoftReference<List<String>>(a);
        a = null;
        if(sr!=null) {
            a = sr.get();
            System.out.println("sr");
        } else {
            a = new ArrayList<>();
            System.out.println("new");
            sr = new SoftReference<List<String>>(a); 
        }
        System.out.println("End");
        
        Person p = new Person("Kitty",36);
        WeakReference<Person> wr = new WeakReference<Person>(p);
        
        int i = 0;
//        while(true) {
//            if(wr.get() != null) {
//                i ++;
//                System.out.println("Object is alive for " + i + " loops -" + wr);
//            } else {
//                System.out.println("Object has been collected");
//                break;
//            }
//        }
        
        String kitty = "Kitty";
        ReferenceQueue rq = new ReferenceQueue();
        PhantomReference<String> pr = new PhantomReference<>(kitty, rq);
        System.out.println(pr.get());
        System.out.println(rq.poll());

        kitty = null;
        System.gc();
        try {
            Reference<String> ref = rq.remove();
            if (ref != null) {
                System.out.println(ref);
                System.out.println(ref == pr);
            }
        } catch (IllegalArgumentException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
