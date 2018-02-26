package multithreading.thread_demo6;

/**
 * Synchronized实现可见性Demo
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/26 17:32
 */
public class SynchronizedDemo {
    //共享变量
    private boolean ready = false;
    private int result = 0;
    private int number = 1;
    private Object syn = 1;

    //写操作
    public synchronized void write() {
        ready = true;
        number = 2;
    }

    //读操作
    public synchronized void read() {
        if (ready) {
            result = number * 3;
        }
        System.out.println("result的值为：" + result);
    }

    private class ReadWriteThread extends Thread {
        //读写标志位
        private boolean flag;

        public ReadWriteThread(boolean flag) {
            this.flag = flag;
        }

        public void run() {
            if (flag) {
                write();
            } else {
                read();
            }
        }
    }

    //测试，会出现0或6两种结果。
    //线程执行顺序和抢cpu资源
    static void test() {
        for (int i = 0; i < 20; i++) {
            SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

            //还有这种操作？
            synchronizedDemo.new ReadWriteThread(true).start();

            synchronizedDemo.new ReadWriteThread(false).start();
        }
    }

    //解决方法1：
    //加入join让线程1先执行完
    static void solution1() {
        for (int i = 0; i < 20; i++) {
            SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

            //还有这种操作？
            Thread thread = synchronizedDemo.new ReadWriteThread(true);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {

            }

            synchronizedDemo.new ReadWriteThread(false).start();
        }
    }

    public static void main(String[] args) {
        test();
        System.out.println("解决方法：");
        solution1();
    }

}