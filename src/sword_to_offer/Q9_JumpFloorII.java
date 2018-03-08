package sword_to_offer;

/**
 * 变态跳台阶（牛客网的题）
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/8 0:27
 */
public class Q9_JumpFloorII {

    //循环
    public int solution(int target) {
        int sum = 1;
        if (target < 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            for (int i = 0; i < target - 1; i++) {
                sum = sum * 2;
            }
            return sum;
        }
    }


    //递归
    public int solution2(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * solution2(target - 1);
        }
    }


}