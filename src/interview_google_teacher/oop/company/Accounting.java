package interview_google_teacher.oop.company;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/25 21:12
 */
public class Accounting {
    BankEndPoint bank;

    void payAll(){
        Employee.loadAllEmployees();
        for (Employee employee: Employee.allEmployees){   //用类引用static变量/函数
            employee.getPaid(bank);

        }
    }
}