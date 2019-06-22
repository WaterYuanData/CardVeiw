package com.yuan.cardview.thread.sync;

import com.yuan.cardview.thread.utils.ThreadUtils;

/**
 * 测 synchronized
 * 一个累加的任务让两个线程做
 */
public class A {

    private int count = 0;

    public int getCount() {
        return count;
    }

    //     不加锁 main==========1992 经常打不到2000
    public void count() {
        // 对象锁，锁住类的实例对象this main==========2000
        //    public synchronized void count() {
        for (int i = 0; i < 1000; i++) {
            ThreadUtils.sleep(1);
            count++;
            System.out.println(Thread.currentThread().getName() + "=" + getCount());
        }
    }

    public static void main(String[] args) {
        A a = new A();
        ThreadA t = new ThreadA(a);
        ThreadA t1 = new ThreadA(a);
        t.start();
        t1.start();
        try {
            t.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("*******");
        }
        System.out.println(Thread.currentThread().getName() + "==========" + a.getCount());
    }
}

class ThreadA extends Thread {
    A mA;

    ThreadA(A a) {
        mA = a;
    }

    @Override
    public void run() {
        super.run();
        mA.count();
    }
}
