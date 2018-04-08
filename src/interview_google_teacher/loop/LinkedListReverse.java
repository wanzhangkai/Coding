package interview_google_teacher.loop;

import interview_google_teacher.common.LinkedListCreator;
import interview_google_teacher.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/18 11:03
 */
public class LinkedListReverse {

    public Node reverseLinkedList(Node head) {
        Node newHead = null;
        Node currentHead = head;
        while (currentHead != null) {
            Node nextNode = currentHead.getNext();  //定义一个nextNode指向下一个节点
            currentHead.setNext(newHead);          //将currentNode反向
            newHead = currentHead;                 //newHead向前推移一位
            currentHead = nextNode;                //currentHead也向前推移一位
        }
        return newHead;
    }


    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListReverse reverse = new LinkedListReverse();

        Node.printLinkedList(
                reverse.reverseLinkedList(creator.CreateLinkedList(new ArrayList<>()))
        );
        Node.printLinkedList(
                reverse.reverseLinkedList(creator.CreateLinkedList(Arrays.asList(1)))
        );
        Node.printLinkedList(
                reverse.reverseLinkedList(creator.CreateLinkedList(Arrays.asList(1, 2, 3, 4, 5)))
        );
        Node.printLinkedList(
                reverse.reverseLinkedList(creator.CreateLargeLinkedList(100000))
        );





    }

}