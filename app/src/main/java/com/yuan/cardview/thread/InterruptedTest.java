package com.yuan.cardview.thread;

/**
 * interrupted()与isInterrupted()的区别
 * */
public class InterruptedTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        String name = Thread.currentThread().getName();
        System.out.println("线程=" + name + " 始 isInterrupted=" + isInterrupted());
        //        静态方法interrupted()执行的过程中会把中断标志重置为false
        while (!Thread.interrupted()) {
            /*
            线程=Thread-0 始 isInterrupted=false
线程=Thread-0 内 isInterrupted=false
线程=Thread-0 内 isInterrupted=false
线程=Thread-0 完 isInterrupted=false
             */

            //        while (!isInterrupted()) {
            /*
            线程=Thread-0 始 isInterrupted=false
线程=Thread-0 内 isInterrupted=false
线程=Thread-0 内 isInterrupted=false
线程=Thread-0 完 isInterrupted=true
             */
            System.out.println("线程=" + name + " 内 isInterrupted=" + isInterrupted());
        }
        System.out.println("线程=" + name + " 完 isInterrupted=" + isInterrupted());
    }
}
