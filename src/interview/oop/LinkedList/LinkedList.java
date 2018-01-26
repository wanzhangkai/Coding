package interview.oop.LinkedList;

import interview.common.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/26 22:31
 */
public class LinkedList implements Iterable<Integer> {   //实现Iterable接口

    Node head;
    Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void add(int value) {
        Node node = new Node(value);
        if (tail == null) {   //tail==null，说明是第一个节点
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    class ListInterator implements Iterator<Integer> {  //内部类
        Node currentNode;

        public ListInterator(Node currentNode) {
            this.currentNode = currentNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Integer next() {
            if (currentNode == null) {
                throw new NoSuchElementException();  //没有下一个元素，throw异常
            }
            int value = currentNode.getValue();
            currentNode = currentNode.getNext();
            return value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListInterator(head);
    }
}