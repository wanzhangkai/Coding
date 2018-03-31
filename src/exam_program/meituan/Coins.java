package exam_program.meituan;

import java.util.Scanner;

/**
 * 拼凑钱币：
 * 给你六种面额 1、5、10、20、50、100 元的纸币，
 * 假设每种币值的数量都足够多，编写程序求组成N元
 * （N为0~10000的非负整数）的不同组合的个数。
 * <p>
 * 动态规划分硬币
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/22 0:17
 */
public class Coins {

    public static long solution(int n) {
        if (n < 0) {
            return 0;
        }
        int[] coins = new int[]{1, 5, 10, 20, 50, 100};
        long[] dp = new long[n + 1];
        dp[0] = 1; //dp[0] 要设置为 1
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                //动态规划-状态转移方程
                //使用前 i 种钱币表示总面额为 j 的方案数 =
                //使用前 i-1 种钱币表示面额为 j 的方案数 +
                //使用前 i 种钱币表示面额为 (j-coins[i]) 的方案数。
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            long res = solution(n);
            System.out.println(res);
        }
    }

}