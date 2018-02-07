package data_structure_and_algorithms.sorting_advance;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/7 23:06
 */
public class QuickSortOp {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        if (r + l <= 15) {   //跟归并排序优化一样，当元素小于16个时才用插入排序
            insertionSort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {

        swap(arr, 1, (int) (Math.random() * (r - l + 1)) + 1);
        Comparable v = arr[l];




    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void insertionSort(Comparable[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > l && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}