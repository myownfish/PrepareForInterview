package com.test.stream;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Delegator implements InvocationHandler {

    private static Method hashCodeMethod;
    private static Method equalsMethod;
    private static Method toStringMethod;

    static {
        try {
            hashCodeMethod = Object.class.getMethod("hashCode", null);
            equalsMethod = Object.class.getMethod("equals", new Class[] { Object.class });
            toStringMethod = Object.class.getMethod("toString", null);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Class[] interfaces;
    private Object[] delegates;

    public Delegator(Class[] interfaces, Object[] delegates) {
        super();
        this.interfaces = interfaces.clone();
        this.delegates = delegates.clone();
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Class declaringClass = m.getDeclaringClass();

        if (declaringClass == Object.class) {
            if (m.equals(hashCodeMethod)) {
                return new Integer(System.identityHashCode(proxy));
            } else if (m.equals(equalsMethod)) {
                return proxyEquals(proxy, args[0]);
            } else if (m.equals(toStringMethod)) {
                return proxyToString(proxy);
            } else {
                throw new InternalError("unexpected Object method dispatched: " + m);
            }
        } else {
            for (int i=0; i < interfaces.length; i++) {
                if (declaringClass.isAssignableFrom(interfaces[i])) {
                    return m.invoke(delegates[i], args);
                }
            }
            
            return invokeNotDelegated(proxy, m, args);
        }
    }

    private Object invokeNotDelegated(Object proxy, Method m, Object[] args) {
        throw new InternalError("unexpected method dispatched: " + m);
    }

    private String proxyToString(Object proxy) {
        return proxy.getClass().getName() + '@' + Integer.toHexString(proxy.hashCode());
    }

    private Boolean proxyEquals(Object proxy, Object other) {
        return (proxy == other ? Boolean.TRUE : Boolean.FALSE);
    }

}
