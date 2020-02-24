package com.test.stream;

public class FooImpl implements Foo, Foo2 {

    @Override
    public Object bar(Object obj) {
        System.out.println(obj);
        return obj;
    }

}
