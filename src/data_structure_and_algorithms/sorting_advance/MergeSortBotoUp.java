package data_structure_and_algorithms.sorting_advance;

import java.util.Arrays;

/**
 * 归并排序的自底向上版：
 * 在统计学上讲，比递归版略慢一点，实际测差不多
 * 但是自底向上有它的好处：因为没有直接通过索引获取数组中的元素，
 * 因而可以使用NlogN的时间对链表这样的数据结构进行排序。（链表只能按顺序读取）
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/6 20:30
 */
public class MergeSortBoToUp {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int size = 1; size <= n; size += size) {
            for (int i = 0; i + size < n; i += size + size) {   //i+size<n 防止i+size越界
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr, i, i + size - 1, Math.min((i + size + size - 1), n - 1));   //Math.min((i + size + size - 1), n - 1) 当(i + size + size - 1)越界时，取n-1
            }
        }
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
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
}