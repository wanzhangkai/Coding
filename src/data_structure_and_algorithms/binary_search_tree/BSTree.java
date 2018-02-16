package data_structure_and_algorithms.binary_search_tree;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/16 22:08
 */
public class BSTree<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;  //根节点
    private int count;  //节点个数

    public BSTree() {
        root = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

}