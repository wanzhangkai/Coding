package exam_program.shenzhouxinxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 请写一个类，在类中定义一个静态方法，
 * 该方法实现用快速排序将数组：
 * int[] input = new int[] { 12, 1, 50, 8, 9, 8, 6, 7, 10, 3 }，
 * 从小到大进行输出。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/1 20:52
 */
public class Main1 {

    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    public static int[] quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return null;
        }

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
        return arr;
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

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String a = in.nextLine();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                StringBuilder sb = new StringBuilder();
                while (i < a.length() && a.charAt(i) != ' ') {
                    sb.append(a.charAt(i));
                    i++;
                }
                if (sb.length() != 0) {
                    list.add(Integer.parseInt(sb.toString()));
                }
            }
            int[] arr = new int[list.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(quickSort(arr)[i]);
                System.out.print(" ");
            }
        }
    }

}