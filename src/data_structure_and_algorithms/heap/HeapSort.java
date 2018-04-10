package data_structure_and_algorithms.heap;

/**
 * 堆排序-优化的堆排序-原地堆排序
 * 数组本身就可以看成是一个堆，因此不需要重新建堆，
 * 直接运用数组的索引来堆排序。(不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序)
 * 优点：不需要开额外的空间，并且效率也比原来高。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/10 20:58
 */
public class HeapSort {

    private HeapSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        //heapify
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown2(arr, n, i);
        }
        //倒序
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown2(arr, i, 0);
        }
    }

    private static void shiftDown(Comparable[] arr, int n, int k) {

        while (2 * k + 1 < n) {
            int j = 2 * k + 1;   //在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j ++;
            }
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值
            if (arr[k].compareTo(arr[j]) >= 0) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    private static void shiftDown2(Comparable[] arr, int n, int k) {
        Comparable e = arr[k];
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;   //在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j ++;
            }
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值
            if (e.compareTo(arr[j]) >= 0) {
                break;
            }
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}
