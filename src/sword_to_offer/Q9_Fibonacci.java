package sword_to_offer;

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项。n<=39
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/6 16:29
 */
public class Q9_Fibonacci {

    //迭代
    public static int solution(int n) {

        int before = 1;
        int after = 1;
        int temp;
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        //n从3开始
        for (int i = 0; i < n - 2; i++) {
            temp = after;
            after = after + before;
            before = temp;
        }
        return after;
    }

    //递归,很简洁，但是n过大会栈溢出
    static int fibonacci(int n) {
        if (n < 0) {
            return 0;
        }
        //当n==1时，递归返回1
        if (n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }


    public static void main(String[] args) {
        System.out.println(solution(9));
        System.out.println(fibonacci(9));
    }

}