package summary_of_knowledge.basic_demo;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/17 16:50
 */
public class Test1 {

    //测试一下String
    public static void test1() {
        String a = "ab";
        String bb = "b";
        String b = "a" + bb;
        System.out.println(a.equals(b));
        String aa = " WANZHANGKai";
        String cc = aa.toLowerCase();
        System.out.println(cc);
    }

    //笔试障眼法的题
    public static int test2(int x) {
        x = (x & 0x55555555) + ((x & 0xaaaaaaaa) >> 1);
        x = (x & 0x33333333) + ((x & 0xdddddddd) >> 2);
        x = (x & 0x0f0f0f0f) + ((x & 0xf0f0f0f0) >> 4);
        x = (x & 0x00ff00ff) + ((x & 0xff00ff00) >> 8);
        x = (x & 0x0000ffff) + ((x & 0xffff0000) >> 16);
        return x;
    }

    public static void main(String[] args) {
//        test1();
        System.out.println(test2(123));
    }
}