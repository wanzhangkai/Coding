package sword_to_offer;

/**
 * 二维数组中的查找:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/4 14:40
 */
public class Q3_Find {

    public static boolean find(int[][] arr, int target) {

        if (arr == null) {  //这些特殊细节都不能忘了写
            return false;
        }

        //从左下开始.(左下和右上是一样的）
        int len = arr.length - 1;
        int i = 0;

        while (len >= 0 && i < arr[len].length) {
            if (target < arr[len][i]) {
                len--;
            } else if (target > arr[len][i]) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[4][3]
        int[][] arr = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        System.out.println(find(arr, 14));
    }

}