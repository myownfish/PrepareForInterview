package com.test.stream;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Lesson6 {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        AccessibleObject ao;
        Class<Person> person = Person.class;
        Constructor<Person> cons = person.getDeclaredConstructor(null);
        if (cons != null) {
            System.out.println(cons +" - isAccessbile: "+ cons.isAccessible());
        }
        cons.setAccessible(true);
        System.out.println(cons +" - isAccessbile: "+ cons.isAccessible());

        
//        Class.newInstance() behaves very much like the new keyword and will fail 
//        for the same reasons new would fail. 
//        The typical solution in reflection is to take advantage of the 
//        java.lang.reflect.AccessibleObject class 
//        which provides the ability to suppress access control checks; 
//        however, this approach will not work because 
//        java.lang.Class does not extend AccessibleObject. 
//        The only solution is to modify the code to use Constructor.newInstance() 
//        which does extend AccessibleObject.


        System.out.println(cons.newInstance());

        person.newInstance();
    }

}
