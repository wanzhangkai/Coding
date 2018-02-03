package interview.loop;

import java.util.Arrays;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/21 22:08
 */
public class BinarySearch {

    public int binarySearch(int[] arr, int key) {
        int fromIndex = 0;
        int toIndex = arr.length;
        while (fromIndex < toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;    //(a+b)/2 有bug，当a和b很大时，会超出int范围
            if (key < arr[mid]) {
                toIndex = mid;
            } else if (key > arr[mid]) {
                toIndex = mid + 1;    //注意这里mid+1赋给下限，因为toIndex取的是arr.length比Index数值多1。
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(
                bs.binarySearch(new int[]{1, 2, 10, 15, 100}, 15));
        System.out.println(
                bs.binarySearch(new int[]{1, 2, 10, 15, 100}, -2));
        System.out.println(
                bs.binarySearch(new int[]{1, 2, 10, 15, 100}, 101));
        System.out.println(
                bs.binarySearch(new int[]{1, 2, 10, 15, 100}, 13));
        System.out.println(
                bs.binarySearch(new int[]{1, 2, 10, 15, 100}, 13));
        System.out.println("======");
        System.out.println(
                bs.binarySearch(new int[]{}, 15));
        System.out.println(
                bs.binarySearch(new int[]{12}, 15));
        System.out.println(
                bs.binarySearch(new int[]{15}, 15));
        System.out.println("======");
        System.out.println(
                bs.binarySearch(new int[]{12, 15}, 15));
        System.out.println(
                bs.binarySearch(new int[]{15, 16}, 15));
        System.out.println("done");
        
    }
}