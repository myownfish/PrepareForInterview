package com.test.stream;

public class IkmTest2 {
    public IkmTest2() {
        this(10);
    }
    public IkmTest2(int data) {
        this.data = data;
    }
    public void display() {
        class Decrementer {
            public void decrement () {
                data--;
            }    
        }
        Decrementer d = new Decrementer();
        d.decrement();
        System.out.println("data = " + data);
    }
   
    private int data;
   
    public static void main (String [] args) {
        int data = 0;
        IkmTest2 t = new IkmTest2();
        t.display();
        System.out.println("data = " + data);
    }
}
