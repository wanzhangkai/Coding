package interview.tree;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/1/21 23:33
 */
public class TreeTraversal {

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void intOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        intOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        intOrder(root.getRight());
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    public String postOrder(String preOrder, String inOrder) {  //已知前中遍历，输出后序遍历
        if (preOrder.isEmpty()) {
            return "";
        }

        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);

        return postOrder(
                preOrder.substring(1, 1 + rootIndex),
                inOrder.substring(0, rootIndex)
        ) + postOrder(
                preOrder.substring(1 + rootIndex),
                inOrder.substring(1 + rootIndex)
        ) + rootValue;
    }


    public static void main(String[] args) {
        TreeTraversal tt = new TreeTraversal();
        TreeCreator creator = new TreeCreator();

        System.out.println("Sample tree traversal");
        tt.preOrder(creator.createSimpleTree());
        System.out.println();
        tt.intOrder(creator.createSimpleTree());
        System.out.println();
        tt.postOrder(creator.createSimpleTree());
        System.out.println();

        System.out.println("Creating tree from preOrder and inOrder");
        TreeNode tree = creator.createTree("ABDEGCF", "DBGEACF");
        tt.postOrder(tree);
        System.out.println();
        TreeNode tree1 = creator.createTree("", "");
        tt.postOrder(tree1);
        System.out.println();
        TreeNode tree2 = creator.createTree("A", "A");
        tt.postOrder(tree2);
        System.out.println();
        TreeNode tree3 = creator.createTree("AB", "BA");
        tt.postOrder(tree3);
        System.out.println();

        System.out.println("Cenerating postOrder directly");
        System.out.println(
                tt.postOrder("ABDEGCF", "DBGEACF")
        );
        System.out.println(
                tt.postOrder("", ""));
        System.out.println(
                tt.postOrder("A", "A"));
        System.out.println(
                tt.postOrder("AB", "BA"));
    }
}