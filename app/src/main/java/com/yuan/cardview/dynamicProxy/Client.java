package com.yuan.cardview.dynamicProxy;

public class Client {
    private static final String TAG = "Client";

    public static void main(String[] args) {
        AFoctory aFoctory = new AFoctory();
        MyComponent myComponent = new MyComponent();
        myComponent.setFectory(aFoctory);
        // ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to com.yuan.cardview.dynamicProxy.AFoctory
        //        AFoctory oneProxy = ((AFoctory) myComponent.getOneProxy());
        A oneProxy = ((A) myComponent.getOneProxy());
        oneProxy.create("66");
    }
}
