package interview.adv;


import interview.designpattern.task.CodingTask;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 多线程示例
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/2 21:45
 */
public class ExecutorTester {


    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<?>> taskResults = new LinkedList<>(); //<?>表示不关心返回的类型
        for (int i = 0; i < 10; i++) {
            taskResults.add(executor.submit(new CodingTask(i)));  //派发任务
        }
        //线程池中运行情况是不确定的
        System.out.println("10 tasks dispatched successfully.");

        for (Future<?> taskResult : taskResults) {
            taskResult.get();   //获得运行的结果
        }

        System.out.println("All tasks finished.");
        executor.shutdown(); // 关闭并回收线程。



    }
}