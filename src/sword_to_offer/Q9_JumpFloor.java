package sword_to_offer;

/**
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：数学归纳法，然后就想到了Fibonacci序列
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/7 21:38
 */
public class Q9_JumpFloor {


    static int solution(int n) {
        if (n < 0) {
            return -1;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        int sum = 0;
        int a = 1;
        int b = 2;

        for (int i = 0; i < n - 2; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }


    //递归
    static int fibonacci(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        //当n==1时，递归返回1
        if (n == 3) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}