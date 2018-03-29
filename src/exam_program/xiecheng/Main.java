package exam_program.xiecheng;

import java.util.Scanner;

/**
 * 携程笔试的三个题：
 * 移动数组中的“0”:
 * 给定一个整型数组，将数组中所有的“0”移动到末尾，
 * 非“0”项保持顺序不变
 * 在原始数组上进行移动操作，勿创建新的数组
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/29 19:23
 */
public class Main {

    public static int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && i != 0) {
                for (int j = i; j > 0; j--) {
                    if (arr[j - 1] == 0) {
                        arr[j - 1] = arr[j];
                        arr[j] = 0;
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                System.out.println(solution(arr)[i]);
            }
        }
    }

}