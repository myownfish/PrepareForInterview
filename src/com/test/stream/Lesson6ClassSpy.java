package com.test.stream;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;

enum ClassMember {CONSTRUCTOR, FIELD, METHOD, CLASS, ALL};
public class Lesson6ClassSpy {
       
    
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {

        Class<?> c = Class.forName(args[0]);
        System.out.format("Class: %n  %s%n%n", c.getCanonicalName());
        c.getMethod("getName");
        Package p = c.getPackage();
        System.out.format("PackageL%n %s%n%n", (p != null ? p.getName() : "-- No Package --"));
        
        for(int i = 1; i < args.length; i ++) {
            switch (ClassMember.valueOf(args[i])) {
            case CONSTRUCTOR:
                printMembers(c.getConstructors(), "Constructor");
                break;
            case FIELD:
                printMembers(c.getFields(), "Fields");
                break;
            case METHOD:
                printMembers(c.getMethods(), "Methods");
                break;
            case CLASS:
                printClasses(c);
                break;
            case ALL:
                printMembers(c.getConstructors(), "Constructor");
                printMembers(c.getDeclaredFields(), "Fields");
                printMembers(c.getMethods(), "Methods");
                printClasses(c);
                break;
            default:
                assert false;
                break;
            }
        }
    }

    private static void printClasses(Class<?> c) {
        System.out.format("Classes:%n");
        Class<?>[] cls = c.getClasses();
        Arrays.stream(cls).forEach(cla -> System.out.format("  %s%n", c.getCanonicalName()));
        if(cls.length == 0) {
            System.out.format(" -- No member interfaces, classes, or enums --%n");
        }
        
    }

    private static void printMembers(Member[] members, String string) {
        System.out.format("%s%n", string);
        Arrays.stream(members).forEach(member -> {
            if(member instanceof Field) {
                System.out.format("  %s%n", ((Field)member).toGenericString());
            } else if(member instanceof Constructor) {
                System.out.format("  %s%n", ((Constructor)member).toGenericString());
            } else if(member instanceof Method) {
                System.out.format("  %s%n", ((Method)member).toGenericString());
            }
            
        });
        if (members.length == 0) {
            System.out.format(" -- No %s --%n", string);
        System.out.format("%n");
        }
        
    }

}
