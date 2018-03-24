package exam_program.meituan;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/21 20:59
 */
public class Test {

    public static void print() {
        System.out.println("MTDP");
    }

    public static void main(String[] args) {
        try {
            //如果print()去掉static，会打印"NullPointerException"
            //因为此时为null类型的对象引用对象的方法，对象为空执行会报错
            //加上static就是null类型的对象调用类的方法，与对象无关了，所以不会报空指针。
            ((Test) null).print();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
    }

}