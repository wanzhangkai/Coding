package interview.oop.company;

import java.util.List;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/25 21:04
 */
public class Employee {
    static List<Employee> allEmployees;

    String name;
    int salary;

    public Employee(String name, int salary) { //构造函数的作用，让用户给出规定的参数
        this.name = name;
        this.salary = salary;
    }

//    public Employee(String name) { //重载一个只有name的构造函数。
//        this.name = name;
//    }

    public Employee(String name) {
        this(name, 0);  //调用自己类里面的构造函数
    }

    void doWork() {

    }

    void getPaid(BankEndPoint bank) {
        bank.payment(name, salary);
    }

    @Override
    public boolean equals(Object o) {  //为了让equals在任何场合都能使用
        if (this == o) return true;    //是否是同一对象，一般不是
        if (o == null || getClass() != o.getClass()) return false;
        //对象不为空 || 两个对象的class是否一样，不一样就false

        Employee employee = (Employee) o;
        //因为传入的是Object类，所以要强制类型转换

        if (salary != employee.salary) return false;
        return name.equals(employee.name);
        //判断两个内容是否一致，一致就反悔true；
        //equals方法重写的目的：同一个类的两个对象如果它们的元素相等，即返回true。
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + salary;
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    static void loadAllEmployees() {   //static中无法用this
        //Loads all employees from db.

    }

}