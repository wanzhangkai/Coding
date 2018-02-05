package data_structure_and_algorithms.sorting_basic;

import data_structure_and_algorithms.common.SortTestHelper;

/**
 * 插入排序：
 * 每次从未排序的数组中按顺序选取一个元素与前面已排的元素对比，如果比它大就交换位置，直到前面没有元素比它大。
 * 复杂度：O(n^2)
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/5 17:22
 */
public class InsertionSort0 {

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(Object[] arr, int a, int b) {
        Object t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.InsertionSort0", arr);


    }


}