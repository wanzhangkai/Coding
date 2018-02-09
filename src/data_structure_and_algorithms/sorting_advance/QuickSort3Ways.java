package data_structure_and_algorithms.sorting_advance;

import data_structure_and_algorithms.sorting_basic.InsertionSort;

/**
 * 快速排序-三路版：
 * 处理重复键值时速度也很快，普通随机序列会比其他两版本慢一点。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/9 19:33
 */
public class QuickSort3Ways {

    public static void sort(Comparable[] arr) {
        quickSort3Ways(arr, 0, arr.length - 1);
    }

    private static void quickSort3Ways(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];

        int lt = l;       // arr[l+1...lt] < v
        int i = l + 1;    // arr[lt+1...i) == v
        int gt = r + 1;   // arr[gt...r] > v

        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else {  //arr[i]==v
                i++;
            }
        }
        swap(arr, l, lt);

        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }


}