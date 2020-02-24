package com.test.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Exam {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//
//        BufferedReader inputStream = new BufferedReader(new File("input.dat"));
//        BufferedReader inputStream1 = new BufferedReader("input.dat");
//          BufferedReader inputStream2 = new BufferedReader(new InputStreamReader("input.dat"));
//          FileReader inputStream3 = new FileReader("input.dat");
////          inputStream3.r
//          BufferedReader inputStream4 = new BufferedReader(new FileReader("input.dat"));
//          inputStream4.readLine();
//          
//          
//          System.out.println("Current JVM Heap Size:"+Runtime.totalMemory());
//          System.out.println("Maximum JVM Heap Size:"+Runtime.maxMemory());
//          System.out.println("Free JVM Heap Size:"+Runtime.freeMemory());
//          System.out.println("Current JVM Heap Size:" + Runtime.getRuntime().totalMemory());
//          System.out.println("Maximum JVM Heap Size:" + Runtime.getRuntime().maxMemory());
//          System.out.println("Free JVM Heap Size:" + Runtime.getRuntime().freeMemory());
//              C.  System.out.println("Current JVM Heap Size:" + Runtime.getRuntime().getTotalHeapMemory(););
//          System.out.println("Maximum JVM Heap Size:" + Runtime.getRuntime().getMaxHeapMemory());
//          System.out.println("Free JVM Heap Size:" + Runtime.getRuntime().getFreeHeapMemory());
//              D.  System.out.println("Current JVM Heap Size:"+Runtime.getMax());
//          System.out.println("Maximum JVM Heap Size:"+Runtime.getUsed());
//          System.out.println("Free JVM Heap Size:"+Runtime.getInit());
//              E.  System.out.println("Current JVM Heap Size:"+Runtime.getRuntime().getCurrentSize());
//          System.out.println("Maximum JVM Heap Size:"+Runtime.getRuntime().getMaxSize());
//          System.out.println("Free JVM Heap Size:"+Runtime.getRuntime().getFreeSize());
          
          
          String str1 = "My String";
          String str2 = new String ("My String");
          System.out.println(str1.equals(str2));
          System.out.println(str1.hashCode() == str2.hashCode());
          System.out.println(str1.matches(str2));
          
          Consumer c;
          Exception e;
          
          YearMonth ym1 = YearMonth.of(2015, Month.SEPTEMBER);
          YearMonth ym2 = YearMonth.of(2016, Month.FEBRUARY);
          
          System.out.println(ym2.until(ym1, ChronoUnit.MONTHS));
          System.out.println(ym2.compareTo(ym1));
          System.out.println(ym1.until(ym2, ChronoUnit.MONTHS));
//          System.out.println(ym1.until(ym2));
          System.out.println(ym1.minus(Period.ofMonths(4)).getMonthValue());
         
          List<String> list = Arrays.asList("dog","over","good");

          System.out.println(list.stream().reduce(new String(), (x1,x2) -> {if (x1.equals("dog"))return x1;return x2;})); 
//          System.out.println(list.stream().reduce(new Character(),(Character s1,s2) -> s1 + s2.charAt(0),(c1,c2) -> c1 += c2)));
          list.stream().reduce( (x1,x2) -> x1.length()==3?  x1:x2).ifPresent(System.out::println);
          System.out.println(list.stream().reduce(new String(),(s1,s2) -> s1 + s2.charAt(0),(c1,c2) -> c1 += c2));
          list.stream().reduce( (x1,x2) -> x1.length() > x2.length()? x1:x2).ifPresent(System.out::println);
    }

}
