package data_structure_and_algorithms.data_structure;

/**
 * 用两个队列实现一个栈
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/11 23:31
 */
public class TwoQueueToStack {

    private Queue queue1;
    private Queue queue2;

    public TwoQueueToStack(int n) {
        queue1 = new Queue(n);
        queue2 = new Queue(n);
    }

    public void push(int data) {
        if (queue1.isFull()) {
            throw new RuntimeException("栈溢出");
        }
        if (queue1.isEmpty() && queue2.isEmpty()) {

        }
        queue1.push(data);
    }

    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int size1 = queue1.getSize();
        int size2 = queue2.getSize();
        if (size1 > size2) {
            for (int i = 0; i < size1 - 1; i++) {  //留下最后一个元素
                queue2.push(queue1.pop());
            }
            return queue1.pop();
        } else {
            for (int i = 0; i < size2 - 1; i++) {  //留下最后一个元素
                queue1.push(queue2.pop());
            }
            return queue2.pop();
        }
    }

    public static void main(String[] args) {
        TwoQueueToStack toStack = new TwoQueueToStack(10);

        for (int i = 0; i < 10; i++) {
            toStack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(toStack.pop() + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            toStack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(toStack.pop() + " ");
        }

    }
}