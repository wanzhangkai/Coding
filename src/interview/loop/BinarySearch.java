package interview.loop;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/21 22:08
 */
public class BinarySearch {

    public int binarySearch(int[] arr, int k) {
        int a = 0;
        int b = arr.length;
        while (a < b) {
            int mid = a + (b - a) / 2;    //(a+b)/2 有bug，当a和b很大时，会超出int范围
            if (k < arr[mid]) {
                b = mid;
            } else if (k > arr[mid]) {
                a = mid +1;
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