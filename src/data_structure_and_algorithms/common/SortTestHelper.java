package data_structure_and_algorithms.common;

import data_structure_and_algorithms.sorting_basic.SelectionSort;

import java.lang.reflect.Method;

/**
 * 排序测试助手
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/4 23:30
 */
public class SortTestHelper {

    private SortTestHelper() {
    }

    //生成随机序列
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;
        //assert，当内容为true时继续执行，为false时停止执行。

        Integer[] arr = new Integer[n];
        //随机序列的写法
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL); //java自动装箱
            //random（）在java中是0.***的小数。
        }
        return arr;
    }

    // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
    public static Integer[] generateNearOrderedArray(int n, int swapTimes) {  //对于近乎有序的数组排序，插入排序相当快
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random()*n);  //随机选取一个位置a
            int b = (int) (Math.random()*n);  //随机选取一个位置b
            int t = arr[a];     //交换位置a与b上的元素
            arr[a] = arr[b];
            arr[b] = t;
        }
        return arr;
    }



    //打印数组
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //判断数组是否排序成功
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    //测试排序arr数组所花费时间，代码简单版,只有SelectionSort
    public static void testSort(Comparable[] arr) {
        long startTime = System.currentTimeMillis();
        SelectionSort.sort(arr);
        System.out.println("This sort cost:"
                + (System.currentTimeMillis() - startTime) + "ms");
    }

    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort0(String sortClassName, Comparable[] arr) {
        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

//            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}