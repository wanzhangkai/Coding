package data_structure_and_algorithms.interview_handwriting;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/8 23:47
 */
public class MyBinarySearch {

    public static boolean binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target < arr[mid]) {
                r = mid - 1;
            } else if (target > arr[mid]) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 9, 13};
        System.out.println(binarySearch(arr, 13));
    }

}