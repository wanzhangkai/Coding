package sword_to_offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 合并两个排序的链表：
 * 输入两个单调递增的链表头结点，输出两个链表合成后的链表头结点，
 * 当然我们需要合成后的链表满足单调不减规则。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/11 13:26
 */
public class Q17_MergeSortedLinkedLists {

    class ListNode {
        int val;
        ListNode next;
    }

    //递归
    public ListNode solution(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //如果head1和head2都为null会返回null的newHead。
        ListNode newHead = null;
        if (head1.val <= head2.val) {
            newHead = head1;
            newHead.next = solution(head1.next, head2);
        } else {
            newHead = head2;
            newHead.next = solution(head1, head2.next);
        }
        return newHead;
    }

    public ListNode solution2(ListNode head1, ListNode head2) {
        return null;
//        ListNode newHead = null;
//        ListNode currentNode = null;
//        if (head1 == null && head2 == null) {
//            return null;
//        }
//        if (head1 == null) {
//            currentNode = head2;
//        } else if (head2 == null) {
//            currentNode = head1;
//        }else {
//            if (head1.val < head2.val) {
//                currentNode = head1;
//                head1 = head1.next;
//            } else {
//                currentNode = head2;
//                head2 = head2.next;
//            }
//        }
//        newHead = currentNode;
//
//        while (head1 != null && head2 != null) {
//            if (head1.val < head2.val) {
//                currentNode.next = head1;
//                currentNode = currentNode.next;
//                head1 = head1.next;
//            } else {
//                currentNode.next = head2;
//                currentNode = currentNode.next;
//                head2 = head2.next;
//            }
//        }
//        while (head1 != null) {
//            currentNode.next = head1;
//            currentNode = currentNode.next;
//            head1 = head1.next;
//        }
//        while (head2 != null) {
//            currentNode.next = head2;
//            currentNode = currentNode.next;
//            head2 = head2.next;
//        }
//        return newHead;
    }

    public static void main(String[] args) {
        List list = new LinkedList<>();
    }

}