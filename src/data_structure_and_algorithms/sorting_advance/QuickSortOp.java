package data_structure_and_algorithms.sorting_advance;

import data_structure_and_algorithms.sorting_basic.InsertionSort;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/7 23:06
 */
public class QuickSortOp {

    //私有化构造函数，不允许产生实例
    private QuickSortOp() {
    }

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }

        if (r - l <= 15) {   //跟归并排序优化一样，当元素小于16个时才用插入排序
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {

        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(Object[] arr, int a, int b) {
        Object temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}