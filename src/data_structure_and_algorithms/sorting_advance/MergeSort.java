package data_structure_and_algorithms.sorting_advance;

import java.util.Arrays;

/**
 * 归并排序
 * 复杂度：O(nlogn)
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/6 14:58
 */
public class MergeSort {

    public static void sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    //递归使用归并排序，对arr[l...r]的范围进行排序
    private static void mergeSort(Comparable[] arr, int l, int r) {
//        if (l >= r) {   //左边界等于或大于右边界返回
//            return;
//        }
        if (r - l <= 15) {
            //当元素数量比较少时，使用插入排序更快，因为当N比较小时，N是比NlogN小的。
            //测试结果表明会快一点点
            insertionSort(arr, l, r);
            return;  //直接排序完毕
        }

        int mid = l + (r - l) / 2;  //类似二分查找的细节
        mergeSort(arr, l, mid);   //左边递归
        mergeSort(arr, mid + 1, r);  //右边递归
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            //当左侧最后一个元素大于右侧第一个元素时，才merge，否则直接跳出merge提高效率。
            //但是对近乎有序的序列，还是没有插入排序快。
            merge(arr, l, mid, r);   //归并起来
        }
    }

    //将arr[l...mid]和arr[mid+1...r]的前闭后闭的两个部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //建立一个临时空间,将arr里的元素和坐标复制给aux
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {      //边界控制,确认索引的合法性
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {  //边界控制
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];  //将两边较小的赋值给arr
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    //带左右边界的插入排序，方便当(r - l <= 15)时使用插入排序更快
    public static void insertionSort(Comparable[] arr, int l, int r) {
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