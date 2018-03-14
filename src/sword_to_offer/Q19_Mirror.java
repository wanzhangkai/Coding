package sword_to_offer;

import data_structure_and_algorithms.data_structure.Tree;

/**
 * 二叉树的镜像：
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 * <p>
 * 思路：先前序遍历该树，如果遍历到的结点有子节点，
 * 就交换它的两个子结点。当交换完所有非叶子结点的
 * 左右子结点后，就得到了镜像树。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/14 15:13
 */
public class Q19_Mirror {

    class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void solution(TreeNode root) {
        //根结点判空
        if (root == null) {
            return;
        }
        //根结点的左右孩子判空，递归的返回条件
        if (root.left == null && root.right == null) {
            return;
        }
        //交换左右子结点
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        //左边有孩子，递归进去继续遍历
        if (root.left != null) {
            solution(root.left);
        }
        //右边有孩子，递归进去继续遍历
        if (root.right != null) {
            solution(root.right);
        }
    }

}