package interview.tree;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/21 23:14
 */
public class TreeNode {
    private final char value;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    public TreeNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public TreeNode getParent() {
        return parent;
    }

    private void setParent(TreeNode parent) {     //setParent被private
        this.parent = parent;
    }

    public char getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
        if (this.left != null) {
            this.left.setParent(this);   //parent节点通过setLeft或setRight设置,保护了parent不被乱设置。
        }
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
        if (this.right != null) {
            this.right.setParent(this);
        }
    }
}