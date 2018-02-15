package data_structure_and_algorithms.binary_search_tree;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/15 15:54
 */
public class BinarySearch {

    public static int binarySearch(Comparable[] arr, Comparable target) {
        int l = 0;
        int r = arr.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;   //细节
            if (target.compareTo(arr[mid]) < 0) {
                r = mid - 1;
            } else if (target.compareTo(arr[mid]) > 0) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[100];
        int j = 50;
        for (int i = 0; i < 100; i++) {
            arr[i] = j;
            j++;
        }
        Integer[] arr2 = {1, 3, 5, 7, 9, 11};
        int a = BinarySearch.binarySearch(arr2, 1);
        System.out.println(a);
    }
}