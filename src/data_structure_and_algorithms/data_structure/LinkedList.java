package data_structure_and_algorithms.data_structure;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/13 22:05
 */
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    class Node<T> {
        private final T value;
        public Node<T> next;

        public Node(T a) {
            this.value = a;
            next = null;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }
    }

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);

        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    public void deleteByIndex(int index) {
        Node<T> temp = head;
        int i = 1;
        while (temp != null) {
            if (i == index - 1) {
                temp.setNext(temp.getNext().getNext());  //跳过第index个节点
                break;
            }
            temp = temp.getNext();
            i++;
        }
    }

    public void traversal() {
        Node<T> temp = head;
        while (temp != null) {
            T a = temp.getValue();
            temp = temp.getNext();
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        list.traversal();
        list.deleteByIndex(6);
        list.traversal();

    }

}