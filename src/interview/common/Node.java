package interview.common;

/**
 * 节点构造
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/12 16:13
 */
public class Node {

    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.getValue());
            System.out.print(" ");
            head = head.getNext();    //head重新指向了next节点
        }
        System.out.println();
    }
}