package data_structure_and_algorithms.data_structure;

/**
 * 树
 * 建树方式采用简单的直接建树
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/14 14:50
 */
public class Tree<T> {

    public class TreeNode<T> { //树的结点

        private final T value;
        private TreeNode<T> left;
        private TreeNode<T> right;
        private TreeNode<T> parent;

        public TreeNode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public T getValue() {
            return value;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
            if (this.left != null) {
                this.left.setParent(this);  //确保parent不被乱设置
            }
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
            if (this.left != null) {
                this.left.setParent(this);  //确保parent不被乱设置
            }
        }

        public TreeNode<T> getParent() {
            return parent;
        }

        private void setParent(TreeNode<T> parent) {  //setParent为private
            this.parent = parent;
        }
    }

    public TreeNode createTree() {   //建一颗简单树
        TreeNode root = new TreeNode('A');
        root.setLeft(new TreeNode('B'));
        root.setRight(new TreeNode('C'));
        root.getLeft().setLeft(new TreeNode('D'));
        root.getLeft().setRight(new TreeNode('E'));
        root.getLeft().getRight().setLeft(new TreeNode('F'));
        root.getRight().setLeft(new TreeNode('G'));
        return root;
    }

    public void preOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }

    public void postOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    public void traversalLeftNode(TreeNode<T> root) {
        TreeNode temp = root;
        while (temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getLeft();
        }
    }

    public static void main(String[] args) {
        Tree<String> tree = new Tree<>();

        tree.preOrder(tree.createTree());
        System.out.println();
        tree.inOrder(tree.createTree());
        System.out.println();
        tree.postOrder(tree.createTree());
        System.out.println();
        tree.traversalLeftNode(tree.createTree());
    }

}
