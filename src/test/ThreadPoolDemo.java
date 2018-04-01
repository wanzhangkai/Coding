package test;

import java.util.concurrent.*;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/28 10:29
 */
public class ThreadPoolDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int n = 3;
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(n);
        Executors.newCachedThreadPool();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i);
                }
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread.start();
        thread1.start();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future thread2 = executor.submit(runnable);
        thread2.get();

    }

}