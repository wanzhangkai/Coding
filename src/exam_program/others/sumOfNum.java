package exam_program.others;

/**
 * 输出整数10到1000的各个位数相加为5的数
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/28 21:36
 */
public class SumOfNum {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 10; i < 1000; i++) {
            int sum = 0;
            int t = i;
            while (t != 0) {
                sum += t % 10;
                t /= 10;
            }
            if (sum == 5) {
                count++;
                System.out.println(i + " ");
                if (count % 5 == 0) System.out.println();
            }
        }
    }
}