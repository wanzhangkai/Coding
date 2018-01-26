package interview.oop.company;

import java.util.LinkedList;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/25 21:21
 */
public class Tester {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 10000);
        Employee employee2 = new Employee("Mary", 20000);
        Employee employee3 = new Employee("John");
        employee3.salary = 10000;

        System.out.println("employee1 == employee3 ？"
                + (employee1 == employee3));   //new了两个，当然不是同一个对象
        System.out.println("employee1.equals(employee3) ？"
                + employee1.equals(employee3));
        //名字一样，工资也一样，但是equals为false？
        System.out.println("employee2.equals(employee3) ？"
                + employee2.equals(employee3));
        System.out.println(employee2);
        System.out.println(employee1);
        System.out.println(employee3);

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        System.out.println("Print using for each:");
        for (Employee e : employees){
            System.out.println(e);
        }

    }
}