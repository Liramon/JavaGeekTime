package com.example.demo;

public class Thread03 {

    public static void main(String[] args) {
        final Object lock = new Object();

        long start = System.currentTimeMillis();

        Thread th = new Thread(() -> {
            System.out.println("异步计算结果为：" + sum());
            synchronized (lock) {
                lock.notify();
            }
        });
        th.start();

        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }


    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

}
