package data_structure_and_algorithms.sorting_basic;

/**
 * 冒泡排序：
 * 两两比较，将较大的放在后面，一轮后，再重新开始比较。
 * 复杂度：O(n^2)
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/5 21:31
 */
public class BubbleSort {

    //写法一,手撸写这个吧，毕竟容易记
    public static void sort(Comparable[] arr) {
        Comparable temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //写法二
    public static void sort0(Comparable[] arr){

        int n = arr.length;
        boolean swapped = false;

        do{
            swapped = false;
            for( int i = 1 ; i < n ; i ++ )
                if( arr[i-1].compareTo(arr[i]) > 0 ){
                    swap( arr , i-1 , i );
                    swapped = true;
                }

            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
            n --;
        }while(swapped);
    }

    //写法三
    public static void sort1(Comparable[] arr){

        int n = arr.length;
        int newn; // 使用newn进行优化

        do{
            newn = 0;
            for( int i = 1 ; i < n ; i ++ )
                if( arr[i-1].compareTo(arr[i]) > 0 ){
                    swap( arr , i-1 , i );

                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            n = newn;
        }while(newn > 0);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}