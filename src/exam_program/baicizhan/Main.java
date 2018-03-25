package exam_program.baicizhan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/25 10:57
 */
public class Main {

    public static int solution1(String str) {
        if (str.length() == 0) {
            return -1;
        }
        int maxNum = 0;
        int temNum = -1;
        int j;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9) {
                for (j = i; j < str.length(); j++) {
                    if (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9) {
                        sb.append(str.charAt(i));
                    }
                    break;
                }
                i = j;
                if (temNum <= Integer.parseInt(sb.toString())) {
                    temNum = Integer.parseInt(sb.toString());
                }
            }
        }
        return temNum;
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {//注意while处理多个case
//            String str = in.next();
//            System.out.println(solution1(str));
//        }
//    }

    public static String solution2(int n, int[] arr) {

        StringBuilder sb = new StringBuilder();

        int tem;
        for (int i = 0; i < n; i++) {
            tem = arr[i];
            sb.append(tem);
            for (int j = i + 1; j < n; j++) {

            }


            if (i + 1 < n && arr[i + 1] - arr[i] == 1) {
                sb.append(arr[i]);

            }


        }


        return null;
    }


    public static void solution3(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            solution3(arr);
        }
    }


}