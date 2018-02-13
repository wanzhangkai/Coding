package data_structure_and_algorithms.data_structure;

/**
 * 两个栈实现一个队列
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/13 21:14
 */
public class TwoStackToQueue {

    //stack1用于push，stack2用于pop
    private Stack stack1;
    private Stack stack2;

    public TwoStackToQueue(int n) {
        stack1 = new Stack(n);
        stack2 = new Stack(n);
    }

    public void push(int data) {
        if (stack1.isFull() && stack2.isFull()) {
            throw new RuntimeException("队列已满");
        }
        if (!stack2.isEmpty()) {
            for (int i = 0; 0 < stack2.getSize(); i++) {
                stack1.push(stack2.pop());
            }
        }
        stack1.push(data);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        if (!stack1.isEmpty()) {
            for (int i = 0; 0 < stack1.getSize(); i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStackToQueue toQueue = new TwoStackToQueue(10);

        for (int i = 0; i < 10; i++) {
            toQueue.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(toQueue.pop() + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            toQueue.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(toQueue.pop() + " ");
        }

    }


}