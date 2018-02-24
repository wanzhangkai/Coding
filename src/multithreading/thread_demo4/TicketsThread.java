package multithreading.thread_demo4;

/**
 * 多线程demo
 * 火车站抢票:
 * 对比extends Thread 和 implements Runnable
 * 两种创建多线程方式
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/24 22:42
 */

public class TicketsThread {

    static class MyThread extends Thread {
        private int ticketsCont = 5;
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (ticketsCont > 0) {
                ticketsCont--;
                System.out.println(name + "卖了1张票，剩余票数为：" + ticketsCont);
            }
        }
    }

    public static void test1() {
        //创建三个线程，模拟三个窗口买票
        MyThread mt1 = new MyThread("窗口1");
        MyThread mt2 = new MyThread("窗口2");
        MyThread mt3 = new MyThread("窗口3");
        mt1.start();
        mt2.start();
        mt3.start();
    }

    /**
     * 1,Runnable方式避免了Java单继承特性的限制；
     * 2，Runnable的代码可以被多个线程（Thread）共享，
     * 适合于多个线程处理同一资源的情况。
     */
    static class MyThread1 implements Runnable {
        private int ticketsCont = 5;

        @Override
        public void run() {
            while (ticketsCont > 0) {
                ticketsCont--;
                System.out.println(Thread.currentThread().getName() + "卖了1张票，剩余票数为：" + ticketsCont);
            }
        }
    }

    public static void test2() {

        MyThread1 mt = new MyThread1();
        Thread mt1 = new Thread(mt, "窗口1");
        Thread mt2 = new Thread(mt, "窗口2");
        Thread mt3 = new Thread(mt, "窗口3");

        mt1.start();
        mt2.start();
        mt3.start();
    }

    public static void main(String[] args) {
        test1();
//        test2();
    }

}