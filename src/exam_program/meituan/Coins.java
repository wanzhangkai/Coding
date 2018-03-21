package exam_program.meituan;

/**
 * 拼凑钱币：
 * 给你六种面额 1、5、10、20、50、100 元的纸币，
 * 假设每种币值的数量都足够多，编写程序求组成N元
 * （N为0~10000的非负整数）的不同组合的个数。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/22 0:17
 */
public class Coins {

    public static int solution(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n >= 1 && n < 5) {
            return 1;
        }
        if (n >= 5 && n < 10) {
            return 2;
        }
        if (n >= 10 && n < 20) {
            return 3;
        }
        if (n >= 20 && n < 50) {
            return 4;
        }
        if (n >= 50 && n < 100) {
            return 5;
        }

return 0;

    }
}