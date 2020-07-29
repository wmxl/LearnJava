package Reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething.");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

public class DynamicProxyHandler implements InvocationHandler {
    private Object proxyed;

    public DynamicProxyHandler(Object proxyed) {
        this.proxyed = proxyed;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("代理工作了.");
        return method.invoke(proxyed, args);
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(), new Class[]{Interface.class},
                new DynamicProxyHandler(real));

        proxy.doSomething();
        proxy.somethingElse("luoxn28");
    }
}