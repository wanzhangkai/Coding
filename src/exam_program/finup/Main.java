package exam_program.finup;

import java.util.Scanner;

/**
 * 给出三个正整数a,b和c，
 * 你可以在它们之间插入加号或者乘号以及括号将其变成一个表达式。
 * 比如给出数字1，2和3，你可以构造出：
 * <p>
 * 1+2*3=7
 * <p>
 * 1*(2+3)=5
 * <p>
 * 1*2*3=6
 * <p>
 * (1+2)*3=9
 * <p>
 * 等表达式。现在你需要构造一个值最大的表达式，输出这个值。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/28 19:44
 */
public class Main {

    public static int solution(int a, int b, int c) {
        int[] sum = new int[4];
        if (a == 1 || b == 1 || c == 1) {
            sum[0] = a + b * c;
            sum[1] = a * (b + c);
            sum[2] = a * b * c;
            sum[3] = (a + b) * c;
            int temp = sum[0];
            for (int i = 0; i < sum.length; i++) {
                if (temp <= sum[i]) {
                    temp = sum[i];
                }
            }
            return temp;
        }
        return a * b * c;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            System.out.println(solution(a, b, c));

        }

    }


}