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
        for (int i = 0; i < index; i++) {
            Node<T> temp = head;
            if (i == index - 2) {
                temp = temp.getNext();
                temp.setNext(temp.getNext().getNext());
                temp.getNext().setNext(null);
            }
        }
    }

    public void traversal() {
        Node<T> temp = head;
        while (temp != null) {
            T a = temp.getValue();
            temp = temp.getNext();
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.traversal();

    }

}