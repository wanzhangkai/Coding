package sword_to_offer;

/**
 * 反转链表：
 * 输入一个链表头结点，反转链表后，输出链表的头结点。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/11 11:15
 */
public class Q16_ReverseList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode solution(ListNode head) {
        //定义三个指针
        //currentNode与newHead用于设置反向next
        //nextNode用于遍历后面的结点
        ListNode newHead = null;
        ListNode currentNode = head;
        ListNode nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = newHead;
            newHead = currentNode;
            currentNode = nextNode;
        }
        return newHead;
    }

}