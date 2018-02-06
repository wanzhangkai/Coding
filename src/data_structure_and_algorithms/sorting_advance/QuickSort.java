package data_structure_and_algorithms.sorting_advance;

/**
 * 快速排序
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/6 21:39
 */
public class QuickSort {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    //对arr[l...r]部分进行partition操作
    //返回p，使得arr[l..p-1] < arr[p], arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        Comparable v = arr[l];

        //arr[l+1...j] < v ; arr[j+1...i] > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}