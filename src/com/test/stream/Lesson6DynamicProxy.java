package com.test.stream;

import java.lang.reflect.Proxy;

public class Lesson6DynamicProxy {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
//
//        Object result = foo.bar("Hello World!");
//        System.out.println("Result is " + result);
        
        
        Class[] proxyInterfaces = new Class[] { Foo.class };
        Foo foo = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), proxyInterfaces, new Delegator(proxyInterfaces, new Object[] {new FooImpl()}));
        foo.bar("Haha YES");
        System.out.println(foo.hashCode());
    }

}
