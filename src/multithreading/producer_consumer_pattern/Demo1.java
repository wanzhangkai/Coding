package multithreading.producer_consumer_pattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者/消费者模型：
 * 使用阻塞队列实现
 * 只有当 Producer 中 put 了元素，
 * Consumer 才能输出
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/29 10:34
 */
public class Demo1 {

    static class Producer implements Runnable {
        private final BlockingQueue sharedQueue;

        public Producer(BlockingQueue sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Produced: " + i);
                    sharedQueue.put(i);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue sharedQueue;

        public Consumer(BlockingQueue sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int i = (Integer) sharedQueue.take();
                    System.out.println("Consumed: " + i);
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            }
        }
    }


    public static void main(String[] args) {
        BlockingQueue sharedQueue = new LinkedBlockingQueue<>();

        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));

        prodThread.start();
        consThread.start();
    }

}