package sword_to_offer;


/**
 * 调整数组顺序使奇数位于偶数前面:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/11 1:24
 */
public class Q14_reOrderArray {

    //比较初级的方法，全部遍历
    public static void solution(int[] arr) {
        int[] tem = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                tem[j++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                tem[j++] = arr[i];
            }
        }
        //再把他们按顺序赋值给arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tem[i];
        }
    }

}