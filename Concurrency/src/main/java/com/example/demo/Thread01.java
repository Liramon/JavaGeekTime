package com.example.demo;

import java.util.concurrent.*;

public class Thread01 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        final ExecutorService executorService = new ThreadPoolExecutor(3, 3, 5, TimeUnit.MINUTES, new LinkedBlockingQueue<>(Integer.MAX_VALUE), new ThreadPoolExecutor.CallerRunsPolicy());

        try{
            Future<Integer> submit = executorService.submit(() -> {
                return sum();
            });
            System.out.println("异步计算结果为：" + submit.get());

            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        }catch (Exception e){

        }
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
