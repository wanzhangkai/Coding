package multithreading.thread_demo5_daemonthread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/25 18:30
 */
public class DaemonThreadDemo {

    static class DaemonThread implements Runnable {

        @Override
        public void run() {
            System.out.println("进入守护线程" + Thread.currentThread().getName());
            try {
                writeToFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("退出守护线程" + Thread.currentThread().getName());
        }

        private void writeToFile() throws Exception {
            File filename = new File("d:" + File.separator + "daemon.txt");
            OutputStream os = new FileOutputStream(filename, true);
            int count = 0;
            while (count < 999) {
                os.write(("\r\nword" + count).getBytes());
                System.out.println("守护线程" + Thread.currentThread().getName()
                        + "向文件中写入word" + count++);
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        //主线程的getName为main
        System.out.println("进入主线程" + Thread.currentThread().getName());
        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);
        thread.setDaemon(true);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("退出主线程" + Thread.currentThread().getName());
    }

}