package interview_google_teacher.designpattern.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/27 16:46
 */
public class Manager implements Role {
    private List<Employee> reporters;

    public Manager(List<Employee> reporters) {
        this.reporters = Collections.unmodifiableList(new ArrayList<>(reporters));
    }

    @Override
    public void doWork() {     //manager选择员工工作
        System.out.println("Manager dispatch work");
        Employee worker = selectReporter();
        worker.doWork();
    }

    @Override
    public String toString() {
        return "Manager";
    }

    private Employee selectReporter() {
        //select a reporter to work.
        return reporters.get(0);
    }


    private void getStocks() {
    }

}