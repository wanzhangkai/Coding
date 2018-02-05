package interview.designpattern.task;

/**
 * 设计模式-Decorator模式
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/1 22:07
 */
public class LoggingRunnable implements Runnable {

    private final Runnable innerRunnable;

    public LoggingRunnable(Runnable innerRunnable) {
        this.innerRunnable = innerRunnable;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("Task started at "
                + startTime);

        innerRunnable.run();

        System.out.println("Task finished. Elapsed time: "
                + ((double)(System.currentTimeMillis() - startTime)/1000)+"s");
    }

}