package sword_to_offer;

import java.util.Stack;

/**
 * 包含min函数的栈：
 * 定义栈的数据结构，请在该类型中实现一个能够得到
 * 栈的最小元素的min函数。在该栈中，调用min、push
 * 及pop的时间复杂度都是O(1).
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/16 10:28
 */
public class Q21_minStack {
    Stack<Integer> dataStack = new Stack<>();
    //min辅助栈，用于记录最小值，保证了min函数的O(1)处理时间。
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        //要push的元素val比辅助栈顶的大，
        //则辅助栈顶再push一个自己栈顶相同的元素，来保证自己栈顶永远是最小的。
        if (!dataStack.isEmpty() && val > minStack.peek()) {
            dataStack.push(val);
            minStack.push(minStack.peek());
        } else {
            //栈为空直接push两个栈；
            dataStack.push(val);
            minStack.push(val);
        }
    }

    public int pop() {
        //两个栈都pop出去
        minStack.pop();
        return dataStack.pop();
    }

    public int top(){
        return dataStack.peek();
    }

    public int min() {
        //辅助栈顶记录的就是最小的
        return minStack.peek();
    }

    public static void main(String[] args) {
        Q21_minStack minStack = new Q21_minStack();
        minStack.push(3);
        minStack.push(4);
        System.out.println(minStack.min());
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.min());
        minStack.push(0);
        System.out.println(minStack.min());
    }

}