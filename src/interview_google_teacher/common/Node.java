package interview_google_teacher.common;

/**
 * 节点构造
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/12 16:13
 */
public class Node<T> {

    private final T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public static <T> void printLinkedList(Node<T> head) {
        while (head != null) {
            System.out.print(head.getValue());
            System.out.print(" ");
            head = head.getNext();    //head重新指向了next节点
        }
        System.out.println();
    }
}