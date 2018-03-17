package summary_of_knowledge.basic_demo;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/16 15:55
 */
public class Test {

    private int pri;  //父类私有成员变量无法继承
    public int pub;

    public void priM() {
        System.out.println("私有方法");
    }

    static {
        System.out.println("父类静态代码块1");
    }

    public Test() {
        System.out.println("父类构造函数");
    }

    static {
        System.out.println("父类静态代码块2");
    }

    public static void main(String[] args) {
        System.out.println("main");
        Test test = new Test();
    }

}