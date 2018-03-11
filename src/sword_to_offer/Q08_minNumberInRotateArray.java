package sword_to_offer;

/**
 * 旋转数组的最小数字:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路：二分查找
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/6 10:32
 */
public class Q08_minNumberInRotateArray {

    //使用二分查找
    int solution(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;   //初始化mid为0，当完全递增时，返回array[0]

        while (array[left] >= array[right]) {
            //当缩小范围只有2个元素时，直接返回右边元素
            if (right - left == 1) {
                return array[right];
            }
            //右移1比 /2 效率高
            mid = left + ((right - left) >> 1);
            //当mid定位在左侧递增范围内时，将范围缩小
            if (array[left] <= array[mid]) {
                left = mid;
            }
            //当mid定位在右侧递增范围内时，将范围缩小
            if (array[mid] <= array[right]) {
                right = mid;
            }
        }
        return array[mid];
    }

    //直接遍历
    //牛客网上的题目写的是非递减序列
    int solution2(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        //注意边界控制为 i < array.length -1
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

}