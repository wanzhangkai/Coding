package multithreading.thread_demo2;

/**
 * 多线程Demo2：
 * “隋唐演义”
 * 知识点：
 * Thread.sleep(millis); 使当前线程休眠，单位毫秒
 * join()会阻塞其他线程，让调用这个方法的线程先执行完
 * yield()会让出cpu调度权，把下次调度机会让给其他线程
 * volatile关键词，多个线程操作同一变量更安全
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/22 20:28
 */
public class Stage extends Thread {

    public void run() {

        System.out.println("欢迎观看隋唐演义");
        //让观众们安静片刻，等待大戏上演
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("sleep() exception");
        }

        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("sleep() exception");
        }

        System.out.println("话说隋朝末年，隋军与农民起义军杀得昏天黑地...");
        ArmyRunnable sui = new ArmyRunnable();
        ArmyRunnable revolt = new ArmyRunnable();
        Thread armyOfSui = new Thread(sui, "Sui");
        Thread armyOfRevolt = new Thread(revolt, "Revolt");

        armyOfRevolt.start();
        armyOfSui.start();
        //让两个线程运行5ms
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("sleep() exception");
        }

        sui.keepRunning = false;
        revolt.keepRunning = false;

        System.out.println("正当双方激战正酣，半路杀出了个程咬金");
        Thread mrCheng = new Thread(new KeyPersonThread(), "MrCheng");
        System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("sleep() exception");
        }

        mrCheng.start();
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            System.out.println("join() exception");
        }

        System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
        System.out.println("谢谢观看隋唐演义，再见！");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}