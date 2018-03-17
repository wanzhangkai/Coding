package summary_of_knowledge.basic_demo;

/**
 * 包装类的各种坑，demo
 * 注意：包装类中Integer,Short,Long有缓存策略，
 * 当值为 -128 ~ 127 范围内时直接从cache缓存数组中去包装对象，因此此时为true。
 * Float和Double类没有缓存策略，因此什么时候都是false。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/16 13:19
 */
public class IntegerDemo {

    public static void main(String[] args) {
        Integer a = 100, b = 100;
        System.out.println(a == b);      //true
        Integer c = 128, d = 128;        //超过了范围
        System.out.println(c == d);      //false

        System.exit(0);

        Short s1 = 10, s2 = 10;
        System.out.println(s1 == s2);    //true
        Short s3 = 128, s4 = 128;
        System.out.println(s3 == s4);    //false

        Double e = 10.0, f = 10.0;
        System.out.println(e == f);      //false

        int int1 = 1000, int2 = 1000;
        System.out.println(int1 == int2); //true
    }
}