package interview_google_teacher.oop.LinkedList;

import interview_google_teacher.common.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/26 22:31
 */
public class LinkedList<T> implements Iterable<T> {   //实现Iterable接口

    private Node<T> head;
    private Node<T> tail;

    public static <T> LinkedList<T> newEmptyList() {  //申明<T>类型给static，不然static不清楚LinkedList<T>的类型
        return new LinkedList<T>();
    }

    private LinkedList() {
        head = null;
        tail = null;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {   //tail==null，说明是第一个节点
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    //因为这个类是包在类LinkedList<T>的里面，所以可以不用带<T>
    private class ListInterator implements Iterator<T> {  //内部类
        private Node<T> currentNode;

        public ListInterator(Node<T> currentNode) {
            this.currentNode = currentNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (currentNode == null) {
                throw new NoSuchElementException();  //没有下一个元素，throw异常
            }
            T value = currentNode.getValue();
            currentNode = currentNode.getNext();
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListInterator(head);
    }
}