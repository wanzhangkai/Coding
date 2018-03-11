package sword_to_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/4 16:39
 */
public class Q05_printListFromTailToHead {

    //先建一个链表节点
    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //用栈
    public static ArrayList<Integer> print1(ListNode listNode) {
        //用栈先装好倒序的值
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.value);
            listNode = listNode.next;
        }

        //将栈中的值pop到ArrayList中
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    //用递归
    ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> print2(ListNode listNode) {
        while (listNode != null) {
            print2(listNode.next);
            arrayList.add(listNode.value);
        }
        return arrayList;
    }

}