package com.yuan.cardview.dynamicProxy;

import android.util.Log;

public class AFoctory implements A {
    private static final String TAG = "AFoctory";

    @Override
    public void create(String string) {
        //        java.lang.reflect.UndeclaredThrowableException
        //        Log.i(TAG, "create: " + string);
        System.out.println("create: " + string);
    }
}
