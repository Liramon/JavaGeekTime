package com.example.demo;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class Thread02 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    return String.valueOf(sum());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "";
            }
        }, executor);

        future.thenAccept(e -> System.out.println("异步计算结果为：" + e));

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
