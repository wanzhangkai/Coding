package sword_to_offer;

/**
 * 二进制中1的个数:
 * 输入一个整数，输出该数二进制表示中1的个数。
 * 例如把9表示成二进制是1001，有2位是1。
 * 因此如果输入9，该函数输出2.
 * 其中负数用补码表示。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/8 15:39
 */
public class Q10_NumberOf1 {

    //普通法
    public static int solution(int num) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    //牛逼一点的解法
    //num - 1 与 num &操作可以减少一位1
    public static int solution2(int num) {
        int count = 0;
        while (num != 0) {
            num = (num - 1) & num;
            count++;
        }
        return count;
    }


}