package com.test.stream;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestExceptionAndError {

    public static void main(String[] args) throws ClassNotFoundException {
        // TODO Auto-generated method stub

//        Exception e;
//        Error er;
//        File f = new File("test.txt");
//        
//        NoClassDefFoundError  le;
//        RuntimeException re;
//        IOException ioe;
        
        NoClassDefFoundError noClassDefError;
        ClassNotFoundException ce;
        System.out.println("Test");
//        Haha h = new Haha();
        
        
//        java.lang.Class.forName("Haha");
//        java.lang.ClassLoader.getSystemClassLoader().loadClass("Tess");
//        Closeable c;
//        AutoCloseable ac;
        
//        try {
//            Thread.sleep(1000l);
//        } catch (InterruptedException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
        
        FileReader file;
        try {
            file = new FileReader("C:\\test\\a.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        BufferedReader fileInput = new BufferedReader(file); 
        
        // Print first 3 lines of file "C:\test\a.txt" 
        for (int counter = 0; counter < 3; counter++) 
            System.out.println(fileInput.readLine()); 
        
        fileInput.close(); 
    }

}
