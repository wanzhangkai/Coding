package sword_to_offer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/18 22:44
 */
public class Q22_IsPopOrder {

    //自己写的水水的解法
    public static boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length) {
            return false;
        }
        if (pushA.length == 1) {
            if (pushA[0] == popA[0]) {
                return true;
            }
            return false;
        }
        //建一个辅助栈
        Stack<Integer> temStack = new Stack<>();
        int i;
        //将出栈顺序的第一个元素在进栈顺序中找到相应的位置为i
        for (i = 0; i < pushA.length; i++) {
            if (popA[0] == pushA[i]) {
                break;
            }
        }
        //将i之前的元素全部push入辅助栈
        for (int j = 0; j <= i; j++) {
            temStack.push(pushA[j]);
        }
        for (int k = 0; k < pushA.length; k++) {
            if (temStack.size() == 0) {
                temStack.push(pushA[++i]);
            }
            //如果不等于栈顶，则依次push入栈顺序i之后的元素
            while (temStack.peek() != popA[k]) {
                if (i + 1 == pushA.length) {
                    return false;
                }
                temStack.push(pushA[++i]);
            }
            //如何出栈顺序等于辅助栈顶，则直接pop出栈顶
            temStack.pop();
        }
        return true;
    }

    /**
     * 比较好的解法
     * 链接：https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
     * 来源：牛客网
     * 举例：
     * 入栈1,2,3,4,5
     * 出栈4,5,3,2,1
     * 首先1入辅助栈，此时栈顶1≠4，继续入栈2
     * 此时栈顶2≠4，继续入栈3
     * 此时栈顶3≠4，继续入栈4
     * 此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
     * 此时栈顶3≠5，继续入栈5
     * 此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
     */
    public static boolean solution(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 4, 5};
        int[] c = {4, 5, 3, 2, 1};
        int[] d = {4, 3, 5, 1, 2};
        System.out.println(isPopOrder(a, b));
        System.out.println(isPopOrder(a, c));
        System.out.println(isPopOrder(a, d));
        System.out.println(solution(a, b));
        System.out.println(solution(a, c));
        System.out.println(solution(a, d));
    }

}