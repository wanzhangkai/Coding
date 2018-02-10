package data_structure_and_algorithms.heap;

/**
 * 堆排-方式二
 * 换一种建树方式
 * 堆排序主要用于动态数据的维护，速度方面不如归并和快排
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/10 18:55
 */
public class HeapSort2 {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        //建树方式不同了
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
}