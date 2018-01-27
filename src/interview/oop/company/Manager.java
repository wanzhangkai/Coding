package interview.oop.company;

import java.util.List;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/27 16:46
 */
public class Manager extends Employee {
    private List<Employee> reporters;

    public Manager(String name, int salary) {
        super(name, salary);     //调用父类Employee的构造函数
    }

    @Override
    public void getPaid(BankEndPoint bank) {   //重写了基类Employee的getPaid方法，属于子类修改基类的行为
        super.getPaid(bank);
        getStocks();           //manager除了获得工资，还能获得股票，因此他的getPaid跟Employee不一样的地方
    }

    @Override
    public void doWork() {     //manager选择员工工作
        Employee worker = selectReporter();
        worker.doWork();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +    //也通过get、set方法访问基类成员变量
                ", salary=" + getSalary() +
                '}';
    }

    private Employee selectReporter() {
        loadReporters();
        return null;
    }

    private void loadReporters() {
        reporters.clear();
        reporters.add(new Employee("John", 10000));
        reporters.add(new Employee("Marry", 20000));
    }

    private void getStocks() {
    }


}