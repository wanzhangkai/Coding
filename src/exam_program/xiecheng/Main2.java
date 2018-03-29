package exam_program.xiecheng;

import java.util.Scanner;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/29 20:07
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            int[] input = new int[3];
            for (int i = 0; i < 3; i++) {
                input[i] = in.nextInt();
            }

            int[] tem = new int[N];
            for (int i = 0; i < N; i++) {
                tem[i] = 0;
            }
            for (int i = 0; i < N; i++) {
                if (input[0] <= arr[i][0] && input[1] <= arr[i][1]) {
                    tem[i] = 1;
                }
            }
            for (int i = 0; i < N; i++) {
                System.out.println(tem[i]);
            }
            for (int i = 0; i < N; i++) {
                if (tem[i] == 1) {
                    System.out.println(arr[i][2]);
                }
            }
        }

    }

}