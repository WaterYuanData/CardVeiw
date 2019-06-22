package com.yuan.cardview.thread.sync;

import com.yuan.cardview.thread.utils.ThreadUtils;

/**
 * 类锁，其实也是对象锁，只不过他的对象是类的class对象实例
 */
public class B {

    private static int sum = 0;

    public static int getSum() {
        return sum;
    }

    //    main==========1985
    //    public static void sum() {
    public static synchronized void sum() {
        for (int i = 0; i < 1000; i++) {
            ThreadUtils.sleep(1);
            sum++;
            System.out.println(Thread.currentThread().getName() + " =" + getSum());
        }
    }

    public static void main(String[] args) {
        B b = new B();
        ThreadB th = new ThreadB(b);
        b = new B();
        ThreadB th1 = new ThreadB(b);

        th.start();
        th1.start();

        try {
            th.join();
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("*******");
        }
        System.out.println(Thread.currentThread().getName() + "==========" + b.getSum());
    }
}

class ThreadB extends Thread {
    B mB;

    ThreadB(B b) {
        mB = b;
    }

    @Override
    public void run() {
        super.run();
        mB.sum();
    }
}
