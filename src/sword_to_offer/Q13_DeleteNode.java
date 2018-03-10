package sword_to_offer;

/**
 * 在O(1)时间删除链表节点：
 * 传入头节点和要删除的节点，在O(1)时间删除该节点。
 * 思路：不能从头结点开始遍历找要删除的前一个节点，
 * 因此直接将要删除的节点的下个节点覆盖要删除的节点，
 * 然后再将该节点的next赋给下下个节点，然后让gc自动
 * 删除多余节点。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/10 22:21
 */
public class Q13_DeleteNode {

    class ListNode {
        private int value;
        ListNode next;
    }

    //特殊情况：删除头节点或者删除尾节点
    public static void solution(ListNode headNode, ListNode delNode) {
        if (headNode == null || delNode == null) {
            return;
        }
        //删除头节点
        if (headNode == delNode) {
            headNode = null;
        } else if (delNode.next == null) {
            //删除尾节点，只能从头遍历了
            while (headNode.next != null) {
                if (headNode.next == delNode) {
                    headNode.next = null;
                }
                headNode = headNode.next;
            }
        } else { //删除中间节点
            headNode.value = headNode.next.value;
            headNode.next = headNode.next.next;
        }
    }

}