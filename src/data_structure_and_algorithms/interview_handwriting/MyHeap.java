package data_structure_and_algorithms.interview_handwriting;

/**
 * 最大堆手写版（面试）
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/10 18:29
 */
public class MyHeap {

    private int[] data;
    private int count;
    private int capacity;

    public MyHeap(int capacity) {
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public void insert(int item) {
        if (count + 1 > capacity) {
            return;
        }
        data[++count] = item;
        shiftUp(count);
    }

    private void shiftUp(int index) {
        int temp;
        while (index > 1 && data[index / 2] < data[index]) {
            temp = data[index / 2];
            data[index / 2] = data[index];
            data[index] = temp;
            index /= 2;
        }
    }

    public int extract() {
        assert count > 0;
        int res = data[1];
        int temp = data[count];
        data[count] = data[1];
        data[1] = temp;
        count--;
        shiftDown(1);
        return res;
    }

    private void shiftDown(int index) {
        int temp;
        while (2 * index <= count) {
            int i = 2 * index;
            if (i + 1 <= count && data[i + 1] > data[i]) {
                i++;
            }
            if (data[i] < data[index]) {
                break;
            }
            temp = data[index];
            data[index] = data[i];
            data[i] = temp;
            index = i;
        }
    }

    public static void main(String[] args) {
        MyHeap maxHeap = new MyHeap(100);
        for (int i = 0; i < 10; i++) {
            maxHeap.insert((int) (Math.random() * 100));
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(maxHeap.extract()+" ");
        }
    }

}