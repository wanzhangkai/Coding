package interview_google_teacher.google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Google在线笔试题
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/3 14:56
 */
public class BeautifulNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = in.nextInt();
            System.out.println("Case #" + i + ":"
                    + beautiful(n));
        }
    }

    private static int beautiful(int n) {
        for (int radix = 2; radix < n; radix++) {
            if (isBeautiful(n, radix)) {
                return radix;
            }
        }
        throw new IllegalStateException("Should not reach here.");
    }

    private static boolean isBeautiful(int n, int radix) {
        while (n > 0) {
            if (n % radix != 1) {
                return false;
            }
            n /= radix;
        }
        return true;
    }

}