package interview.tree;

/**
 * 这种树的遍历写起来麻烦点，但是不会栈溢出
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/23 21:18
 */
public class InOrderNextNode {

    public TreeNode next(TreeNode node) {     //用循环写树的遍历，比递归难写一点
        if (node == null) {
            return null;
        }

        if (node.getRight() != null) {
            return first(node.getRight());
        } else {
            while (node.getParent() != null &&
                    node.getParent().getLeft() != node) {
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    public TreeNode first(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode curNode = node;
        while (curNode.getLeft() != null) {
            curNode = curNode.getLeft();
        }
        return curNode;
    }

    public void traverse(TreeNode root) {
        for (TreeNode node = first(root); node != null; node = next(node)) {
            System.out.print(node.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeCreator creator = new TreeCreator();
        InOrderNextNode inOrder = new InOrderNextNode();

        TreeNode sampleTree = creator.createSimpleTree();
        inOrder.traverse(sampleTree);

        inOrder.traverse(creator.createTree("",""));
        inOrder.traverse(creator.createTree("A", "A"));
        inOrder.traverse(creator.createTree("AB", "BA"));
        inOrder.traverse(creator.createTree("ABCD", "DCBA"));
        inOrder.traverse(creator.createTree("ABCD", "ABCD"));

    }
}