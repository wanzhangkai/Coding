package multithreading.thread_demo7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Volatile关键字不能保证原子性的Demo
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/26 21:10
 */
public class VolatileDemo {

    //volatile使得number能被所有线程看到
    private volatile int number = 0;

    //重用锁
    private Lock lock = new ReentrantLock();

    public int getNumber() {
        return this.number;
    }

    public void increase() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        //加锁方式一
//        //synchronized(this){} 增加number++操作的原子性
//        synchronized (this) {
//            this.number++;
//        }

        //加锁方式二
        //通过ReentrantLock和try｛｝finally｛｝加锁和解锁
        //java.util.concurrent.locks.ReentrantLock;
        lock.lock();  //加锁
        try {
            this.number++;
        } finally {
            lock.unlock(); //解锁
        }

    }

    public static void main(String[] args) {
        //匿名内部类访问外部类局部变量必须为final属性
        final VolatileDemo demo = new VolatileDemo();
        for (int i = 0; i < 300; i++) {
            //还有这种操作，很直接
            //匿名内部类
            //直接new一个线程，在里面重写run方法，然后直接start。
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.increase();
                }
            }).start();
        }
        //如果还有子线程在运行，主线程就让出CPU资源，
        //直到所有的子线程都运行完了，主线程再继续往下执行。
        //记住这个操作
        //Thread.activeCount() > 1 不能运行？
        //有很多人测试的activeCount的结果是2，
        //是因为有部分的编辑器运行会多一个线程，
        //用dos运行就不会多一个线程了!
        //所以这里修改为 >2
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//
//        }
        System.out.println("number:" + demo.getNumber());
    }

}