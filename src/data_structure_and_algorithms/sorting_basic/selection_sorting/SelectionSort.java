package data_structure_and_algorithms.sorting_basic.selection_sorting;

import java.util.Arrays;

/**
 * 选择排序：
 * 每次从未排序的数组中选取最小的元素，放到未排序的最前面。
 * 复杂度：O(n*n)
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/4 14:27
 */
public class SelectionSort {

    //面试手撸代码版
    public static void sortSimple(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swapSimple(arr, i, minIndex);
        }
    }

    private static void swapSimple(int[] arr, int i, int minIndex) {
        int tem = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tem;
    }


    //Comparable版，通用
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }


    private static void swap(Object[] arr, int i, int minIndex) { //注意这里arr的类型变为通用的Object
        Object tem = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tem;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        SelectionSort.sortSimple(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectionSort.sort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        String[] c = {"D", "C", "B", "A"};
        SelectionSort.sort(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();

        Student[] d = new Student[]{
                new Student("D",90),
                new Student("A",90),
                new Student("C",90),
                new Student("B",90)};
        SelectionSort.sort(d);
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }









    }


}