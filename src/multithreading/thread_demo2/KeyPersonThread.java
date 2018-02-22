package multithreading.thread_demo2;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/22 20:33
 */
public class KeyPersonThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "开始了战斗！");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "进攻隋军");
        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗！");
    }
}