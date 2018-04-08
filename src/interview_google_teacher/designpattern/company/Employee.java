package interview_google_teacher.designpattern.company;

import java.util.List;
import java.util.Objects;

/**
 * 设计模式，案例
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/25 21:04
 */
public class Employee {
    public static List<Employee> allEmployees;

    private final String name;
    private final int salary;
    private Role role;

    public Employee(String name, int salary, Role role) {
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    public void doWork() {
        role.doWork();
    }

    public void getPaid(BankEndPoint bank) {
        bank.payment(name, salary);
    }

    @Override
    public boolean equals(Object o) {  //为了让equals在任何场合都能使用
        if (this == o) return true;    //是否是同一对象，一般不是
        if (o == null || getClass() != o.getClass()) return false;
        //对象不为空 || 两个对象的class是否一样，不一样就false

        Employee other = (Employee) o;
        //因为传入的是Object类，所以要强制类型转换

        return Objects.equals(this.name, other.name)
                && Objects.equals(this.salary, other.salary)
                && Objects.equals(this.role, other.role);
        //判断两个内容是否一致，一致就反悔true；
        //equals方法重写的目的：同一个类的两个对象如果它们的元素相等，即返回true。
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, role);
    }

    @Override
    public String toString() {
        return "Employee[" +
                "name='" + name +
                ", salary=" + salary +
                ", role=" + role +
                "]";
    }

    public String getName() {
        return name;
    }


    public int getSalary() {
        return salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //Package private for logic in the package
    //when employees are loaded.
    //默认就是包内部私有，package private
    static void loadAllEmployees() {   //static中无法用this
        //Loads all employees from db.
    }
}