package interview_google_teacher.loop;

import interview_google_teacher.common.LinkedListCreator;
import interview_google_teacher.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/18 23:11
 */
public class LinkedListDeleter {

    //删除链表中的节点，根据输入的value
    //这里public后面声明了一下<T>，来保证Node<T>和T是一致的类型
    public <T> Node<T> deleteNodeIfEqualsValue(Node<T> head, T value) {
        while (head != null && head.getValue() == value) {  //判断头节点是否等于value
            head = head.getNext();
        }
        if (head == null) {     //头结点不能为空，为了后面循环顺利
            return null;
        }
        Node pre = head;
        while (pre.getNext() != null) {
            if (pre.getNext().getValue() == value) {
                pre.setNext(pre.getNext().getNext());    //跳过了等于value的这个节点
            } else {
                pre = pre.getNext();
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListDeleter deleter = new LinkedListDeleter();
        LinkedListCreator creator = new LinkedListCreator();

        Node.printLinkedList(
                deleter.deleteNodeIfEqualsValue(
                        creator.CreateLinkedList(Arrays.asList(1, 2, 3, 4, 5)), 2
                )
        );
        Node.printLinkedList(
                deleter.deleteNodeIfEqualsValue(
                        creator.CreateLinkedList(Arrays.asList(2,2,2,2,5)),2
                )
        );
        Node.printLinkedList(
                deleter.deleteNodeIfEqualsValue(
                        creator.CreateLinkedList(Arrays.asList(1,2,2,2,2)),2
                )
        );
        Node.printLinkedList(
                deleter.deleteNodeIfEqualsValue(
                        creator.CreateLinkedList(Arrays.asList(2,2,2,2,2)),2
                )
        );
        Node.printLinkedList(
                deleter.deleteNodeIfEqualsValue(
                        creator.CreateLinkedList(Arrays.asList(1,2,1,1,1)),2
                )
        );
        Node.printLinkedList(
                deleter.deleteNodeIfEqualsValue(
                        creator.CreateLinkedList(new ArrayList<>()),2
                )
        );
        Node.printLinkedList(
                deleter.deleteNodeIfEqualsValue(
                        creator.CreateLinkedList(Arrays.asList(2)),1
                )
        );

    }


}

