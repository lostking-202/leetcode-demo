package com.example.demo.leetcode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264804593397984
 *
 *  jdk动态代理是基于反射实现的，代理接口，jvm生成的实现接口的代理类,重写方法
 *
 *
 */
public class HelloProxy {

    public static void main(String[] args) {

       /* Hello hello= (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),new Class[]{Hello.class},handler);
        hello.sayHello();*/

        Hello hello= (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),HelloImpl.class.getInterfaces(),new HelloInvocationHandler(new HelloImpl()));
        hello.sayHello();
    }
}
interface Hello{
    void sayHello();
}
class HelloImpl implements Hello{

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
class HelloInvocationHandler implements InvocationHandler{

    Object target;

    public HelloInvocationHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("good morning");
        Object result=method.invoke(target,args);
        return result;
    }
}
