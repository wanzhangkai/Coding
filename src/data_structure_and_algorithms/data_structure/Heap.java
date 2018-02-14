package data_structure_and_algorithms.data_structure;

/**
 * 堆
 * 堆(数据结构上）的定义：
 * 1）完全的二叉树；2）满足有序，子节点全都比父节点大或者小。（最大堆或者最小堆）
 * 因为堆是完全的二叉树，因此可以用数组实现
 * 以最大堆为例
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/14 15:54
 */
public class Heap {

    private Comparable[] data;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        data = new Comparable[capacity + 1];
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Comparable data) {
        assert size + 1 <= capacity;
        this.data[size + 1] = data;
        size++;
        shiftUp(size);
    }

    public Comparable extractMax() {
        if (size == 0) {
            throw new RuntimeException("堆为空");
        }
        Comparable ret = data[1];

        Comparable temp = data[1];
        data[1] = data[size];
        size--;        //删除了元素
        shiftDown(1);

        return ret;
    }

    private void shiftUp(int k) {   //较大数向上移
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            Comparable temp = data[k / 2];
            data[k / 2] = data[k];
            data[k] = temp;
            k /= 2;
        }
    }

    private void shiftDown(int k) {   //较小数往下移
        while (2 * k <= size) {
            int i = 2 * k;
            if (i + 1 <= size && data[i + 1].compareTo(data[i]) > 0) {
                i++;
            }
            if (data[k].compareTo(data[i]) >= 0) {
                break;
            }
            Comparable temp = data[k];
            data[k] = data[i];
            data[i] = temp;
            k = i;  //交换位置后，k变为i继续向下传递。
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(100);
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(heap.extractMax() + " ");
        }
    }


}