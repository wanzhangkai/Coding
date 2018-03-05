package sword_to_offer;

import java.util.Arrays;

/**
 * 重建二叉树:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/5 17:21
 */
public class Q6_reConstructBinaryTree {

    //先写一个树节点
    class TreeNode {
        private final int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //已知前序和中序来建树
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        int rootIndex = 0;
        for (int i = 0; i < in.length; i++) {
            //遍历in来确认中序root的位置
            if (in[i] == pre[0]) {
                rootIndex = i;
                break;
            }
        }

        /**
         * 要注意一个细节：
         * Arrays.copyOfRange(arr, from, to) 是前闭后开区间，
         * 即arr[to]这个值是取不到的。
         */
        root.left = reConstructBinaryTree(
                Arrays.copyOfRange(pre, 1, rootIndex + 1),
                Arrays.copyOfRange(in, 0, rootIndex)
        );
        root.right = reConstructBinaryTree(
                Arrays.copyOfRange(pre, rootIndex + 1, pre.length),
                Arrays.copyOfRange(in, rootIndex + 1, in.length)
        );
        return root;
    }

}