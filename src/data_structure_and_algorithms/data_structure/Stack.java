package data_structure_and_algorithms.data_structure;

/**
 * 数组实现栈
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/11 23:19
 */
public class Stack {

    private Object[] stack;
    private int top;
    private int size;

    public Stack(int n) {
        stack = new Object[n];
        this.top = 0;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == stack.length;
    }

    public int getSize(){
        return size;
    }

    public void push(Object data) {
        if (isFull()) {
            throw new RuntimeException("栈溢出");
        }
        size++;
        stack[size - 1] = data;
        top = size - 1;
    }

    public Object pop() {
        if (isEmpty()) {
            top = 0;
            throw new RuntimeException("栈为空");
        }
        size--;
        return stack[top--];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        System.out.println(stack.size);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.size);
        for (int i = 0; i < 10; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        System.out.println(stack.size);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.size);
        for (int i = 0; i < 10; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

}