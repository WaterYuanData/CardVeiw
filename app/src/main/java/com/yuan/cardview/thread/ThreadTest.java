package com.yuan.cardview.thread;

import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable的使用
 */
public class ThreadTest {
    private static final String TAG = "ThreadTest";

    // 静态方法只能调用静态内部类
    static class CallableTest implements Callable<String> {

        @Override
        public String call() throws Exception {
            //            ExecutionException: java.lang.RuntimeException: Stub!
            //            Log.i(TAG, "call: ");
            System.out.println(TAG + " call()");
            return "result";
        }
    }

    public static void main(String[] args) {
        // 静态方法只能调用静态内部类
        CallableTest callableTest = new CallableTest();
        FutureTask<String> stringFutureTask = new FutureTask<>(callableTest);
        // Callable的实现类必须经过FutureTask封装才能被Thread使用
        new Thread(stringFutureTask).start();
        try {
            String s = stringFutureTask.get();
            //            Log.i(TAG, "main: stringFutureTask=" + s);
            System.out.println("main: stringFutureTask=" + s);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
