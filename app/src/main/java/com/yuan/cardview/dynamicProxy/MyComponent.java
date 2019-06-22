package com.yuan.cardview.dynamicProxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyComponent implements InvocationHandler {
    private static final String TAG = "MyComponent";
    Object factory;

    public void setFectory(Object factory) {
        this.factory = factory;
    }

    Object getOneProxy() {
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefor();
        Object result = method.invoke(factory, args);
        doAfter();
        return result;
    }

    private void doBefor() {
        //        java.lang.RuntimeException: Stub!
        //        Log.i(TAG, "doBefor: ");
        System.out.println("doBefor");
    }

    private void doAfter() {
        //        Log.i(TAG, "doAfter: ");
        System.out.println("doAfter");

    }
}
