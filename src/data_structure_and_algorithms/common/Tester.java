package data_structure_and_algorithms.common;

import java.util.Arrays;

/**
 * 排序测试类
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/5 18:33
 */
public class Tester {

    public static void main(String[] args) {

        int N = 1000000;
        System.out.println("Test for random array, size = " + N
                + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
//        Integer[] arr1 = SortTestHelper.generateNearOrderedArray(N, 0);  //对于近乎有序的数组排序，插入排序/希尔排序会变得相当快

        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);  //复制一个相同数组
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr7 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr8 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr9 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr10 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr11 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr12 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr13 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr14 = Arrays.copyOf(arr1, arr1.length);

        Integer[] arr15 = new Integer[]{25,11,-6,20,99,9};


//        SortTestHelper.printArray(arr1);
//        SortTestHelper.testSort(arr1);
//        SortTestHelper.printArray(arr1);

//        SortTestHelper.printArray(arr2);
//        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.SelectionSort", arr2);
//        SortTestHelper.printArray(arr2);

//        SortTestHelper.printArray(arr3);
//        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.InsertionSort0", arr3);
//        SortTestHelper.printArray(arr3);

//        SortTestHelper.printArray(arr4);
//        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.InsertionSort", arr4);
//        SortTestHelper.printArray(arr4);

//        SortTestHelper.printArray(arr5);
//        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.BubbleSort", arr5);
//        SortTestHelper.printArray(arr5);

//        SortTestHelper.printArray(arr6);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.ShellSort", arr6);
//        SortTestHelper.printArray(arr6);

//        SortTestHelper.printArray(arr7);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_advance.MergeSort", arr7);
//        SortTestHelper.printArray(arr7);

//        SortTestHelper.printArray(arr8);
//        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_advance.MergeSortBoToUp", arr8);
//        SortTestHelper.printArray(arr8);

//        SortTestHelper.printArray(arr9);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_advance.QuickSort", arr15);
        SortTestHelper.printArray(arr15);

//        SortTestHelper.printArray(arr10);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_advance.QuickSort2", arr10);
//        SortTestHelper.printArray(arr10);

//        SortTestHelper.printArray(arr11);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_advance.QuickSort3Ways", arr11);
//        SortTestHelper.printArray(arr11);

//                SortTestHelper.printArray(arr12);
        SortTestHelper.testSort0("data_structure_and_algorithms.heap.HeapSort1", arr12);
//        SortTestHelper.printArray(arr12);

//        SortTestHelper.printArray(arr13);
        SortTestHelper.testSort0("data_structure_and_algorithms.heap.HeapSort2", arr13);
//        SortTestHelper.printArray(arr13);

//        SortTestHelper.printArray(arr14);
        SortTestHelper.testSort0("data_structure_and_algorithms.heap.HeapSort", arr14);
//        SortTestHelper.printArray(arr14);
    }
}