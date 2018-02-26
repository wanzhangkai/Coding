package multithreading.thread_demo7;

/**
 * Volatile关键字不能保证原子性的Demo
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/26 21:10
 */
public class VolatileDemo {

    //volatile使得number能被所有线程看到
    private volatile int number = 0;

    public int getNumber() {
        return this.number;
    }

    public void increase() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        this.number++;
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
        //为什么不能运行？
//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("number:" + demo.getNumber());
    }

}