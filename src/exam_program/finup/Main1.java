package exam_program.finup;

import java.util.Scanner;

/**
 * 小明是一个间谍，现在他的任务是将一个整数n传给一个客户。
 * 但是他十分担心信号被窃取后，这个数字就暴漏了。于是他决定
 * 换一种表达方式，他将n换成一个整数x，使得x减去x的每个数位
 * 上的数字后不小于n，那么最小的满足条件的x就是小明想要找的。
 * 现在小明需要传送一个整数m，你能帮助他找到这个x么？
 * 如n = 12，当x = 20时，20 - 2 - 0 >= 12.
 * 如n = 9，当x = 10时，10 - 1 - 0 >= 9.
 * 如n = 999，当x = 1000时，1000 - 1 >= 999.
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/28 20:04
 */
public class Main1 {

    public static int solution(int n) {
        int a = n % 10; //求个位数
        int x = n + 10 - a; //求比n大10的数（减去个位数）
        //计算 x 的所有位的和
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        //当 x - n 大于x的所有位的和时结束循环
        while (x - n < sum) {
            sum = 0;
            x = x + 10;
            int temp1 = x;
            //再次计算 x 的所有位的和
            while (temp1 != 0) {
                sum += temp1 % 10;
                temp1 /= 10;
            }
        }
        return x;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            System.out.println(solution(n));
        }
    }

}