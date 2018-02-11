package data_structure_and_algorithms.data_structure;

/**
 * 数组实现队列
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/11 22:28
 */
public class Queue {

    private int[] queue;
    private int head;
    private int size;

    public Queue(int n) {
        queue = new int[n];
        this.head = 0;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void push(int data) {

        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        if (isEmpty()) {
            head = 0;
        }
        size++;
        queue[size - 1] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        size--;
        return queue[head++];
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(10);
        System.out.println(myQueue.size);
        for (int i = 0; i < 10; i++) {
            myQueue.push(i);
        }
        System.out.println(myQueue.size);
        for (int i = 0; i < 10; i++) {
            System.out.print(myQueue.pop() + " ");
        }
        System.out.println();
        System.out.println(myQueue.size);
        for (int i = 0; i < 10; i++) {
            myQueue.push(i);
        }
        System.out.println(myQueue.size);
        for (int i = 0; i < 10; i++) {
            System.out.print(myQueue.pop() + " ");
        }

    }

}