package sword_to_offer;

import java.util.Stack;

/**
 * 用两个栈实现队列:
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/6 9:55
 */
public class Q7_twoStackToQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    //push只由stack1负责
    public void push(int val) {
        stack1.push(val);
    }

    //如果stack1有数据就将stack1全部pop到stack2，
    // 然后stack2 pop出一个元素，再将stack2全部pop到stack1
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int temp = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return temp;
    }

}