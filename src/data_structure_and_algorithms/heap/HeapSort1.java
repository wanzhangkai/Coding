package data_structure_and_algorithms.heap;

/**
 * 堆排-方式一
 * 先建空堆，再一个个按顺序插入元素并且每次都shiftUp
 *
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/10 14:40
 */
public class HeapSort1 {

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);

        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
}