package data_structure_and_algorithms.sorting_advance;

import data_structure_and_algorithms.sorting_basic.InsertionSort;

/**
 * 快速排序
 * 不优化的话，当测试用例为近乎有序的数组或者存在大量重复的元素时，
 * 快速排序很有可能会栈溢出，因为它一直以前面小的元素为分界点，
 * 栈会不够用。此时它的复杂度退化为O(n^2)。
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

        if (r - l <= 15) {   //跟归并排序优化一样，当元素小于16个时才用插入排序
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    //对arr[l...r]部分进行partition操作
    //返回p，使得arr[l..p-1] < arr[p], arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        //优化处理，取范围内的随机Index与l位交换，解决近乎有序的序列的问题，也不会栈溢出

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