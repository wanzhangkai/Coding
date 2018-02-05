package data_structure_and_algorithms.sorting_basic;

import data_structure_and_algorithms.common.SortTestHelper;

import java.util.Arrays;

/**
 * 排序测试类
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/5 18:33
 */
public class Tester {

    public static void main(String[] args) {

        int N = 10000;
        System.out.println("Test for random array, size = " + N
        + " , random range [0, " + N + "]" );

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
//        Integer[] arr1 = SortTestHelper.generateNearOrderedArray(N, 100);  //对于近乎有序的数组排序，插入排序/希尔排序会变得相当快

        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);  //复制一个相同数组
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);


        SortTestHelper.printArray(arr1);
        SortTestHelper.testSort(arr1);
        SortTestHelper.printArray(arr1);

        SortTestHelper.printArray(arr2);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.SelectionSort", arr2);
        SortTestHelper.printArray(arr2);

        SortTestHelper.printArray(arr3);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.InsertionSort0", arr3);
        SortTestHelper.printArray(arr3);

        SortTestHelper.printArray(arr4);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.InsertionSort", arr4);
        SortTestHelper.printArray(arr4);

        SortTestHelper.printArray(arr5);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.BubbleSort", arr5);
        SortTestHelper.printArray(arr5);

        SortTestHelper.printArray(arr6);
        SortTestHelper.testSort0("data_structure_and_algorithms.sorting_basic.ShellSort", arr6);
        SortTestHelper.printArray(arr6);


    }
}