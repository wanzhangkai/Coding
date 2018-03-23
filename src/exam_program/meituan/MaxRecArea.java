package exam_program.meituan;

import java.util.Scanner;

/**
 * 最大矩形面积
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/22 17:07
 */
public class MaxRecArea {

    public static int solution(int n, int[] array) {
        if (n <= 0 || array.length == 0) {
            return 0;
        }

        //找一下最大的元素
        int maxElement = array[0];
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (maxElement < array[i]) {
                maxElement = array[i];
                maxIndex = i;
            }
        }

        int maxArea = 0;
        int tempArea = 0;
        //从最高元素开始切面积
        for (int i = 0; i < maxElement; i++) {

            //从头到位遍历元素大小
            for (int j = 0; j < n; j++) {

            }


        }
        return 0;
    }

    public static int getMaxArea(int[] height) {
        int len = height.length;
        int max = 0;//存储最大面积的
        for (int i = 0; i < len; i++) {//i表示依次遍历每一个高度
            int minHeight = height[i];//设i为最小高度 
            for (int j = (i + 1); j < len; j++) {
                minHeight = Math.min(minHeight, height[j]);//找出i之后的最小高度
                max = Math.max(max, (j - i + 1) * minHeight);//计算以最小高度为高度的最大面积值
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getMaxArea(arr));
    }

}
