package interview.designpattern.task;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/1 22:02
 */
public class CodingTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Writing code.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);   //包装成RuntimeException抛出，偷懒的办法
        }

    }
}