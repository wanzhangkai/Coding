package exam_program.tcl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有一个数字字符串"25 11 -6 20 99 9",
 * 数字之间用空格间隔，
 * 利用任意排序算法对这串数字按照从小到大排序，
 * 生成一个数值有序的字符串"-6 9 11 20 25 99"
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/3 23:14
 */
public class Main {

    public static String sort(String str) {
        //先把字符串转换为数组;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (i < str.length() && str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
                i++;
            }
            if (sb.length() != 0) {
                list.add(Integer.parseInt(sb.toString()));
            }
        }
        //讲list中的元素放入int[]中
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        //使用快速排序
        quickSort(arr, 0, arr.length - 1);
        //将排好序的数组再次组合成字符串返回
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb2.append(arr[i]);
            sb2.append(" ");
        }
        return sb2.toString();
    }

    //快速排序
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
        return;
    }

    private static int partition(int[] arr, int l, int r) {

        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        //优化处理，取范围内的随机Index与l位交换，解决近乎有序的序列的问题，也不会栈溢出

        int v = arr[l];

        //arr[l+1...j] < v ; arr[j+1...i] > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    //交换ab位置
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //测试用例
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "25 11 -6 20 99 9";
        System.out.println(sort(str));
    }

}