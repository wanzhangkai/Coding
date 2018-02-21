package data_structure_and_algorithms.binary_search_tree;

import java.util.LinkedList;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/16 22:08
 */
public class BSTree<Key extends Comparable<Key>, Value> {

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    //层序遍历 -- 一层一层按顺序遍历
    public void levelOrder() {
        levelOrder(root);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    // 向二分搜索树中插入一个新的(key, value)数据对
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    //确认是否有这个元素
    public boolean contain(Key key) {
        return contain(root, key);
    }

    //返回最小节点的键值
    public Key minimum() {
        if (count != 0) {
            Node minNode = minimum(root);
            return minNode.key;
        }
        return null;
    }

    //返回最大节点的键值
    public Key maximum() {
        if (count != 0) {
            Node maxNode = maximum(root);
            return maxNode.key;
        }
        return null;
    }

    //移除最小键值的节点
    public void removeMin() {
        removeMin(root);
    }

    //移除最大键值的节点
    public void removeMax() {
        removeMax(root);
    }

    public void remove(Key key) {
        remove(root, key);
    }

    //节点
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }

        private Value getValue() {
            return value;
        }
    }

    private Node root;  //根节点
    private int count;  //节点个数

    //构造初始化
    public BSTree() {
        root = null;
        count = 0;
    }

    /***************
     * 实现部分
     **************/
    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的二分搜索树的根
    private Node insert(Node node, Key key, Value value) {

        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0)
            node.value = value;
        else if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key, value);
        else    // key > node->key
            node.right = insert(node.right, key, value);

        return node;
    }

    // 查看以node为根的二分搜索树中是否包含键值为key的节点, 使用递归算法
    private boolean contain(Node node, Key key) {

        if (node == null)
            return false;

        if (key.compareTo(node.key) == 0)
            return true;
        else if (key.compareTo(node.key) < 0)
            return contain(node.left, key);
        else // key > node->key
            return contain(node.right, key);
    }

    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public Value search(Key key) {
        return search(root, key);
    }

    // 在以node为根的二分搜索树中查找key所对应的value, 递归算法
    // 若value不存在, 则返回NULL
    private Value search(Node node, Key key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0)
            return node.value;
        else if (key.compareTo(node.key) < 0)
            return search(node.left, key);
        else // key > node->key
            return search(node.right, key);
    }

    //前序遍历
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    //后序遍历
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value + " ");
        }
    }

    //层序遍历 -- 一层一层按顺序遍历
    private void levelOrder(Node root) {

        //使用LinkedList可以当作队列使用
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

//        //使用Java自带Queue
//        Queue<Node> queue = new java.util.LinkedList<>();
//        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.key + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //返回以node为根的二分搜索树的最小键值所在的节点
    private Node minimum(Node root) {
//        if (root.left == null) {
//            return root;
//        }
//        return minimum(root.left);

        //非递归写法
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    //返回以node为根的二分搜索树的最小键值所在的节点
    private Node maximum(Node root) {
        //非递归写法
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根,反悔的还是root
    //递归删除有个问题：只能删除到root为止
    private Node removeMin(Node node) {
        if (node.left == null) {
            //递归最后一层返回：当左孩子为null时，
            //将右孩子临时保存，count--，返回右孩子给上一层并作为上一层的left。
//            Node rightNode = node.right;
//            node.right = null;   //?
            count--;
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            count--;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { //key == node.key
            if (node.left == null) {
                count--;
                return node.right;
            }
            if (node.right == null) {
                count--;
                return node.left;
            }
            //最关键的一步：if node.left != null && node.right != null
            Node rightMin = new Node(minimum(node.right)); //取得右子树最小键值的Node信息，并用新节点保存
            rightMin.left = node.left;
            rightMin.right = removeMin(node.right); //移除右子树的最小值，并且复制右子树的根给最小值
            // 上面removeMin已经count--了！
            return rightMin;
        }
    }

    // 测试二分搜索树
    public static void main(String[] args) {

        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = arr[pos];
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）

        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BSTree<Integer, String> bst = new BSTree<Integer, String>();
        for (int i = 0; i < N; i++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(new Integer(i));
            if (i < N)
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }
    }


}