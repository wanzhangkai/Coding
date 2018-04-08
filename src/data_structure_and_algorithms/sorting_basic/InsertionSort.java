package data_structure_and_algorithms.sorting_basic;

/**
 * 想象一下玩扑克牌时如何排序扑克的。
 * 插入排序：
 * （不再需要swap函数交换位置，因为一次交换位置是三次赋值。）
 * 取出待排的元素，将这个元素的值不断与前面比较，然后前面不断赋值给后面，
 * 找到合适的位置后，再将待排元素插入到选好的位置。（这才叫插入排序啊!）
 * 复杂度：O(n^2)
 * 对于近乎有序的数组排序，插入排序相当快,而真实数据中很多都是近乎有序的。此时的复杂度无限接近于O(n)
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/5 20:00
 */
public class InsertionSort {

    private InsertionSort(){}

    // 对整个arr数组使用InsertionSort排序
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Comparable e = arr[i];  //等待排序的元素
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {      //插入排序的优势：可以提前终止内层循环
                arr[j] = arr[j - 1];   //前面元素赋值给后面
            }
            arr[j] = e;   //将这个等待的e赋值到找好的位置
        }
    }

    //对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r) {
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