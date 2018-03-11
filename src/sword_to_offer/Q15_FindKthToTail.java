package sword_to_offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/11 1:43
 */
public class Q15_FindKthToTail {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode solution(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode node1 = null;
        int count = 0;
        //第一次遍历，计算链表长度
        while (node != null) {
            node = node.next;
            count++;
        }
        //当k不在count范围内
        if (count < k || k < 1) {
            return node1;
        } else {
            //第二次遍历链表
            for (int i = 0; i < count - k + 1; i++) {
                node1 = head;
                head = head.next;
            }
            return node1;
        }
    }

}