package exam_program.toutiao;

import java.util.Scanner;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/24 19:01
 */
public class Main {

    //第一题
    public static int solution(int[] arr, int k) {
        int tem;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            tem = arr[i];
            int a = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (a == arr[j]) {
                    continue;
                }
                if ((arr[j] - tem == k) || (tem - arr[j] == k)) {
                    count++;
                }
                a = arr[j];
            }
        }
        return count;
    }

    //第一题
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNextInt()){
//            int[] k = new int[2];
//            for (int i = 0; i < 2; i++) {
//                k[i] = in.nextInt();
//            }
//            int[] n = new int[k[0]];
//            for (int i = 0; i < k[0]; i++) {
//                n[i] = in.nextInt();
//            }
//            System.out.println(solution(n, k[1]));
//        }
//    }

    //第二题
    public static int solution2(int n) {
        String s = "a";
        String m = s;

        int count = 0;
        if (n % 2 == 1) {
            while (s.length() != n) {
                s = s + m;
                count++;
            }
            return count;
        } else {
            while (s.length() != n) {
                if (s.length() + m.length() == n) {
                    s = s + m;
                    count++;
                    break;
                }
                m = s;
                s = s + s;
                count++;
            }
            return count;
        }
    }

    //第二题
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//            int n =  in.nextInt();
//            System.out.println(solution2(n));
//        }
//    }




    //第五题
    public static int solution4(int N, int K, int H, int[] T) {
        int init = 0;
        int tem = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                if (T[j] - init <= H) {
                    if (tem <= T[j]) {
                        tem = T[j];
                    }
                }
            }
            init = init + (tem - init) * 2;
        }
        return init;
    }

    //第五题
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int[] NKH = new int[3];
            for (int i = 0; i < 3; i++) {
                NKH[i] = in.nextInt();
            }
            int[] T = new int[NKH[0]];
            for (int i = 0; i < NKH[0]; i++) {
                T[i] = in.nextInt();
            }
            System.out.println(solution4(NKH[0], NKH[1], NKH[2], T));
        }
    }

}