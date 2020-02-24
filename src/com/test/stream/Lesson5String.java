package com.test.stream;

public class Lesson5String {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String s1 = "haha";
        String s2 = "haha";
        System.out.println(s1 == s2);
        
        String s3 = new String("xiexie");
        s3 = s3.intern();
        String s4 = new String("xiexie");
        s4 = s4.intern();
        System.out.println(s3 == s4);
        
        String s5 = new String("haha");
        s5 = s5.intern();
        System.out.println(s1 == s5);
        
        

        
    }

}
