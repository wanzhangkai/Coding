package summary_of_knowledge.basic_demo;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/16 16:01
 */
 public class Sub extends Test {

    @Override
    public void priM() {

    }

    static {
        System.out.println("子类静态代码块1");
    }

    public Sub() {
        System.out.println("子类构造函数");
    }

    static {
        System.out.println("子类静态代码块2");
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.pub = 3;
        System.out.println(sub.pub);

        //私有成员变量或者私有方法，没有get/set方法是无法调用的
        Test test = new Test();
    }

}