package data_structure_and_algorithms.interview_handwriting;

import java.util.Arrays;

/**
 * 几大常用排序的手写精简版（面试需要）
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/20 17:22
 */
public class MySort {

    //快速排序: 时间复杂度 O(nlogn) - 空间复杂度 O(log2n)~O(n) - 不稳定 - 交换排序 - 分治算法
    //三路快排
    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l + 1;
        int lt = l;
        int rt = r + 1;
        int temp;
        int p = arr[l];
        while (i < rt) {
            if (arr[i] < p) {
                temp = arr[i];
                arr[i] = arr[lt + 1];
                arr[lt + 1] = temp;
                lt++;
                i++;
            } else if (arr[i] > p) {
                temp = arr[i];
                arr[i] = arr[rt - 1];
                arr[rt - 1] = temp;
                rt--;
            } else {
                i++;
            }
        }
        temp = arr[l];
        arr[l] = arr[lt];
        arr[lt] = temp;
        quickSort(arr, l, lt - 1);
        quickSort(arr, rt, r);
    }


    //归并排序：时间复杂度 O(nlogn) - 空间复杂度 O(n) - 稳定 - 归并排序 - 分治算法
    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l] < temp[j - l]) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    //堆排序：时间复杂度 O(nlog2n) - 空间复杂度 O(1) - 不稳定 - 选择排序
    private static void heapSort() {
    }

    //直接插入排序: 时间复杂度 O(n^2) - 空间复杂度 O(1) - 稳定 - 插入排序
    private static void insertionSort(int[] arr) {
        int temp;
        int j;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    //希尔排序: 时间复杂度 O(n^1.3) - 空间复杂度 O(1) - 不稳定 - 插入排序
    private static void shellSort(int[] arr) {
        int h = arr.length;
        while (h > 0) {
            h = h / 2;
            for (int i = h; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                for (; j >= h && temp < arr[j - h]; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = temp;
            }
        }
    }

    //直接选择排序：时间复杂度 O(n^2) - 空间复杂度 O(1) - 不稳定 - 选择排序
    private static void selectionSort(int[] arr) {
        int tempIndex;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            tempIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[tempIndex] > arr[j]) {
                    tempIndex = j;
                }
            }
            temp = arr[tempIndex];
            arr[tempIndex] = arr[i];
            arr[i] = temp;
        }
    }

    //冒泡排序：时间复杂度 O(n^2) - 空间复杂度O(1) - 稳定 - 交换排序
    private static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 3, 1, 11, 6, 12, 4, 2, 0};
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
//        shellSort(arr);
//        quickSort(arr, 0, arr.length - 1);
        mergeSort(arr, 0, arr.length - 1);
        for (int arrs : arr) {
            System.out.print(arrs + " ");
        }
    }

}