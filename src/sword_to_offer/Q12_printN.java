package sword_to_offer;

/**
 * 打印1到最大的n位数：
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。
 * 比如输入3，则打印出1、2、3一直到最大的3位数即999。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/8 23:24
 */
public class Q12_printN {

    public static void solution(int num) {

        int i = 0;
        int tem = 1;
        while (i < num) {
            tem = tem * 10;
            i++;
        }
        for (i = 1; i < tem; i++) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        solution(2);
    }




}