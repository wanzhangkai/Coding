package exam_program._360;

import java.util.Scanner;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/31 19:40
 */
public class Main {

    public static int solution(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int count = 0;

        while (arr[0] != 0 || arr[1] != 0 || arr[2] != 0) {
            if (arr[0] == 0 && arr[1] == 0) {
                break;
            }
            if (arr[0] == 0 && arr[2] == 0) {
                break;
            }
            if (arr[1] == 0 && arr[2] == 0) {
                break;
            }
            int temp = 0;
            int a = 0;
            while (temp < 3 && (arr[0] != 0 || arr[1] != 0 || arr[2] != 0) && a < 2) {
                a++;
                for (int i = 0; i < 3; i++) {
                    if (arr[i] != 0 && temp < 3) {
                        ++temp;
                        arr[i] = arr[i] - 1;
                    }
                }
            }
            if (temp == 3) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int[] rgb = new int[3];
                for (int j = 0; j < 3; j++) {
                    rgb[j] = in.nextInt();
                }
                System.out.println(solution(rgb));
            }
        }
    }
}