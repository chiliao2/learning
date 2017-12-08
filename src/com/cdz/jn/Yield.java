package com.cdz.jn;

public class Yield {
    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            try {
                synchronized (o) {
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    System.out.println(Thread.currentThread().getName() + "放弃锁");
                    o.wait(2000);
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "执行完毕");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread1");
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                synchronized (o) {
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    System.out.println(Thread.currentThread().getName() + "放弃锁");
                    o.wait(2000);
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "执行完毕");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread2");
        t2.start();
    }
}
