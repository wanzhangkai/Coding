package interview_google_teacher.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Linked List Creator
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/12 16:13
 */
public class LinkedListCreator {

    /**
     * Creates a linked list
     *
     * @param data the data to create the list
     * @return head of the linked list.
     */

    public Node CreateLinkedList(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }
        Node firstNode = new Node(data.get(0));
        Node subListNode =
                CreateLinkedList(data.subList(1, data.size()));    //recursion
        firstNode.setNext(subListNode);
        return firstNode;   //返回头结点就行
    }

    public Node CreateLargeLinkedList(int size) {   //用递归会stackOverflow(栈溢出）
        Node prev = null;
        Node head = null;
        for (int i = 1; i <= size; i++) {
            Node node = new Node(i);   //新建一个带有值但没有链接的孤立节点，new=在内存上开辟了空间
            if (prev != null) {
                prev.setNext(node);    //prev的next指向node节点，setNext（）相当于把两个孤立的Node接起来了
            } else {
                head = node;           //head指向node节点，head就指了这么一次，后面全是prev在操作
            }
            prev = node;               //prev指向node节点
        }
        return head;   //返回头结点
    }


    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();

        Node.printLinkedList(
                creator.CreateLinkedList(new ArrayList<>())
        );
        Node.printLinkedList(
                creator.CreateLinkedList(Arrays.asList(1))
        );
        Node.printLinkedList(
                creator.CreateLinkedList(Arrays.asList(1, 2, 3, 4, 5))
        );

        Node.printLinkedList(creator.CreateLargeLinkedList(100));

    }

}