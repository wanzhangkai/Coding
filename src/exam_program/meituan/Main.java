package exam_program.meituan;

import java.util.Scanner;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/22 18:42
 */
public class Main {

    public static int solution(String a, String b) {
        if (a == null && b == null) {
            return 0;
        }
        if (a == null) {
            return b.length();
        }
        if (b == null) {
            return a.length();
        }

        int count = 0;
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            }
            return count;
        }

        return ((a.length() - b.length()) > 0) ? a.length() : b.length();
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String a, b;

        a = cin.next();
        b = cin.next();
        System.out.println(solution(a, b));
    }

    public static int solution2(String str) {

        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            if (1 == (str.charAt(i) - '0')) {
                flag++;
            }
        }
        if (flag == 0) {
            return 1;
        }


        int min = str.charAt(0) - '0';
        for (int i = 0; i < str.length(); i++) {
            if (min > (str.charAt(i) - '0')) {
                min = str.charAt(i) - '0';
            }
        }
        if (min >= 1) {
            return 1;
        }

        return 1;
    }

    public static void main1(String args[]) {
        Scanner cin = new Scanner(System.in);
        String a;
        a = cin.next();
        System.out.println(solution2(a));
    }


//    public static void main(String args[]) {
//        Scanner cin = new Scanner(System.in);
//        String a, b;
////        while(cin.hasNextInt())
////        {
////            a = cin.next();
////
////        }
//        a = cin.next();
//        b = cin.next();
//        System.out.println(solution(a, b));
//    }

}