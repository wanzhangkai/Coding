package data_structure_and_algorithms.sorting_basic;

/**
 * 希尔排序-与插入排序一脉相承：
 * Shell首先将间隔设定为n/2，然后跳跃进行插入排序，再来将间隔n/4，跳跃进行排序动作，再来
 * 间隔设定为n/8、n/16，直到间隔为1之后的最后一次排序终止，由于上一次的排序动作都会将
 * 固定间隔内的元素排序好，所以当间隔越来越小时，某些元素位于正确位置的机率越高，因此
 * 最后几次的排序动作将可以大幅减低。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/5 22:07
 */
public class ShellSort {

    //写法一，简洁手撸版
    public static void sort(Comparable[] arr) {
        int h = arr.length;

        while (h > 0) {
            h = h / 2;  //间隙每次取1/2
            for (int i = h; i < arr.length; i++) {  //分了d组
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }
        }
    }

    //写法二，似乎更快一点点
    public static void sort0(Comparable[] arr) {

        int n = arr.length;

        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }
            h /= 3;
        }

    }

}