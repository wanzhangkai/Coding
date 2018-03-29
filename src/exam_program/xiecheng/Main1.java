package exam_program.xiecheng;

import java.util.Scanner;

/**
 * 给一个N*N的二维矩阵，将该矩阵顺时针旋转90度:
 * 输入:输入一个N*N二维矩阵
 * 输出:将输入的二维矩阵顺时针旋转90度
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/29 19:42
 */
public class Main1 {

    public static int[][] solution(int[][] arr) {
        int[][] tempArr = new int[arr[0].length][arr.length];
        int temIndex = arr.length - 1;
        for (int i = 0; i < arr.length; i++, temIndex--) {
            for (int j = 0; j < arr[0].length; j++) {
                tempArr[j][temIndex] = arr[i][j];
            }
        }
        return tempArr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(solution(arr)[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int[] arr = new int[1000000];
//            while (in.hasNextInt()){
//
//        }
//    }

}