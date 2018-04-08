package interview_google_teacher.recursion;

import interview_google_teacher.common.LinkedListCreator;
import interview_google_teacher.common.Node;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/12 23:45
 */
public class LinkedListReverse {

    public Node reverseLinkedList(Node head) {
        // siez == 0 or size ==1;
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static void main(String[] arg) {
        LinkedListReverse linkedListReverse = new LinkedListReverse();
        LinkedListCreator creator = new LinkedListCreator();

        Node head1 = creator.CreateLinkedList(new ArrayList<>());
        Node head2 = creator.CreateLinkedList(Arrays.asList(1));
        Node head3 = creator.CreateLinkedList(Arrays.asList(1, 2, 3, 4, 5));

        head1.printLinkedList(linkedListReverse.reverseLinkedList(head1));
        head1.printLinkedList(linkedListReverse.reverseLinkedList(head2));
        head1.printLinkedList(linkedListReverse.reverseLinkedList(head3));

    }


}