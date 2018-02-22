package multithreading;

/**
 * 多线程简单demo
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/22 17:33
 */
public class ThreadDemo1 {

    //创建线程方式一：继承Thread
    //Thread() implements Runnable
    //实际上创建线程都要implements Runnable
    static class Thread1 extends Thread {

        public void run() {
            System.out.println(getName() + "is a actor!");
            int count = 0;
            boolean keepRunning = true;

            while (keepRunning) {
                System.out.println(getName() + " show：" + (++count));
                if (count == 100) {
                    keepRunning = false;
                }
                if (count % 10 == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("sleep() exception");
                    }
                }
            }
            System.out.println("Show Over!");
        }
    }

    //notice the different between two pattern
    //直接 implements Runnable
    static class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "is a actor!");
            int count = 0;
            boolean keepRunning = true;

            while (keepRunning) {
                System.out.println(Thread.currentThread().getName() + " show：" + (++count));
                if (count == 100) {
                    keepRunning = false;
                }
                if (count % 10 == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("sleep() exception");
                    }
                }
            }
            System.out.println("Show Over!");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        thread1.setName("thread1");
        Thread thread2 = new Thread(new Thread2(), "thread2");
        thread1.start();
        thread2.start();
    }

}