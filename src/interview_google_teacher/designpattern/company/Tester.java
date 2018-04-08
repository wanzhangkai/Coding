package interview_google_teacher.designpattern.company;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/25 21:21
 */
public class Tester {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 10000, new Engineer());
        //这里显示了多态的作用，Employee要求的传参为（String name，int salary，Role role）
//      //这里我们new Engineer（）或者 Manager（）来实现不同的Role；
        Employee employee2 = new Employee("Mary", 20000, new Engineer());

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(employee1);
        employees.add(employee2);

        System.out.println("Print using for each:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("Testing managers");
        employee2.setRole(new Manager(Arrays.asList(employee1)));
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("Testing doWork");
        System.out.println("Employee1");
        employee1.doWork();
        System.out.println("Employee2");
        employee2.doWork();

    }
}