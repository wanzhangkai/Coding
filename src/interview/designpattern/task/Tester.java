package interview.designpattern.task;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/1 22:14
 */
public class Tester {

    public static void main(String[] args) {

        //设计模式-Decorator模式
        //CodingTask外面装饰了2层其他功能。
        new LoggingRunnable(
                new TransactionalRunnable(
                        new CodingTask())).run();

    }
}