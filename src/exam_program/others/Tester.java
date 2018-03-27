package exam_program.others;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/27 12:48
 */
public class Tester {

    //百鸡百钱问题
    public static void solution() {
        int x, y, z;
        for (x = 0; x < 20; x++) {
            for (y = 0; y < 33; y++) {
                z = 100 - x - y;
                if (z % 3 == 0 && (5 * x + 3 * y + z / 3) == 100) {
                    System.out.println(x + "," + y + "," + z);
                }
            }
        }
        System.out.println("done");
    }

    public static void main(String[] args) {
        solution();
    }

}