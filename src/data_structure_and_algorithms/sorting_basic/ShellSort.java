package data_structure_and_algorithms.sorting_basic;

/**
 * 希尔排序-与插入排序一脉相承：
 *
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/5 22:07
 */
public class ShellSort {

    public static void sort(Comparable[] arr){

        int n = arr.length;

        int h = 1;
        while (h< n/3){
            h = 3*h+1;
        }

        while (h >= 1) {

        }

    }

    public static void main(String[] args) {

    }

}