package com.test.stream;

import java.beans.MethodDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

public class Lesson6Class {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
        // TODO Auto-generated method stub
//        java.lang.reflect.Method method = new Method(null, null, null, null, null, 0, 0, null, null, null, null);

        Class<String> c1 = (Class<String>) "Hello".getClass();
        Class<String> c2 = (Class<String>) (new String("Hello")).getClass();

        System.out.println(c1);
        System.out.println(c2);
        
      
        Class c3 = E.A.getClass();
        System.out.println(c3);
        
        byte[] bytes = new byte[1024];
        Class c4 = bytes.getClass();
        System.out.println(c4);
        
        Set<String> s = new HashSet<String>();
        Class c5 = s.getClass();
        System.out.println(c5);

        Class c6 = boolean.class;  // correct
        Class c61 = Boolean.TYPE;
        System.out.println(c6);
        System.out.println(c6 == c61);

        
        Class c7 = int[][][].class;
        System.out.println(c7);
        
        Class c8 = Class.forName("com.test.stream.Exam");
        System.out.println(c8);

        Class c9 = Void.TYPE;
        Class c91 = Void.TYPE;
        System.out.println(c9);

        Class<?>[] c10 = Character.class.getClasses();
        Arrays.stream(c10).forEach(System.out::println);
        
        Field f = System.class.getField("out");
        Class c11 = f.getDeclaringClass();
        System.out.println(c11);

        Class person = Person.class;
        System.out.println(person.getName());
        System.out.println(person.getCanonicalName());
        System.out.println(Modifier.toString(person.getModifiers()));
        System.out.println(person.getGenericSuperclass());
        TypeVariable[] tv = person.getTypeParameters();
        System.out.println(tv.length);

        BiFunction<String, String, Integer> function = (a, b) -> {String r = (a + b); return r == null? 0 : r.length();};
        System.out.println(function.getClass());
        List<String> list = new ArrayList<String>();
        System.out.println((list.getClass().getTypeParameters()[0]).getName());

    }

}
enum E { A, B }
