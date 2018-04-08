package data_structure_and_algorithms.interview_handwriting;

/**
 * 几大常用排序的手写精简版（面试需要）
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/20 17:22
 */
public class Sort {

    //快速排序
    private static void quickSort() {


    }

    //归并排序
    private static void mergeSort() {

    }

    //堆排序
    private static void heapSort() {

    }

    //直接插入排序: 时间复杂度 O(n^2) - 空间复杂度 O(1) - 稳定 - 插入排序
    private static void insertionSort(int[] arr) {
        int temp;
        int j;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    //希尔排序:
    private static void shellSort() {

    }

    //直接选择排序：时间复杂度 O(n^2) - 空间复杂度 O(1) - 不稳定 - 选择排序
    private static void selectionSort(int[] arr) {
        int tempIndex;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            tempIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[tempIndex] > arr[j]) {
                    tempIndex = j;
                }
            }
            temp = arr[tempIndex];
            arr[tempIndex] = arr[i];
            arr[i] = temp;
        }
    }

    //冒泡排序：时间复杂度 O(n^2) - 空间复杂度O(1) - 稳定 - 交换排序
    private static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 3, 1};
//        bubbleSort(arr);
//        selectionSort(arr);
        insertionSort(arr);
        for (int arrs : arr) {
            System.out.print(arrs + " ");
        }
    }

}