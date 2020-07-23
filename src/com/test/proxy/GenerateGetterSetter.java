package com.test.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GenerateGetterSetter implements InvocationHandler {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        User user = new User();
        user.setUsername("haha");
        System.out.println(user.getUsername());
//        GenerateGetterSetter getter = new GenerateGetterSetter(user);
        DomainObject proxyUser =  (DomainObject) GenerateGetterSetter.generatePorxy(user);
        proxyUser.setUsername("Kitty");
        System.out.println(proxyUser.getUsername());

    }

    Object target;

    public GenerateGetterSetter(Object target) {
        this.target = target;
    }

    public static Object generatePorxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new GenerateGetterSetter(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        Field name = target.getClass().getDeclaredField("name");
        name.setAccessible(true);
        if (method.getName().startsWith("get")) {
            return name.get(target);
        }
        if (method.getName().startsWith("set")) {
            name.set(target, args[0]);
        }
        return null;
    }

}
