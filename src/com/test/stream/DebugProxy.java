package com.test.stream;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DebugProxy implements InvocationHandler {
    
    private Object obj;
    
    public DebugProxy(Object obj) {
        super();
        this.obj = obj;
    }

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(), 
                obj.getClass().getInterfaces(), 
                new DebugProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Object result;
        System.out.println("before method " + m.getName());
        result = m.invoke(obj, args);
        System.out.println("after method " + m.getName());
        return result;
    }

}
