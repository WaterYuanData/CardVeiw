package com.yuan.cardview.thread.utils;

/**
 * 封装下sleep方法，免的一直处理异常
 */
public class ThreadUtils {
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("************");
        }
    }
}
