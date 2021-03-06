package com.example.demo;

import java.util.concurrent.CountDownLatch;

public class Thread04 {

    public static void main(String[] args) {
        final CountDownLatch cdl = new CountDownLatch(1);

        long start = System.currentTimeMillis();

        Thread th = new Thread(() -> {
            System.out.println("异步计算结果为：" + sum());
            cdl.countDown();
        });
        th.start();

        try {
            cdl.await();
        }catch (InterruptedException e){
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
