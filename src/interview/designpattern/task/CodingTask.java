package interview.designpattern.task;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/1 22:02
 */
public class CodingTask implements Runnable {

    private final int employeeId;

    public CodingTask(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public void run() {
        System.out.println("Employee " + employeeId + " started writing code.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);   //包装成RuntimeException抛出，偷懒的办法
        }

        System.out.println("Employee " + employeeId + " finished writing code.");

    }
}