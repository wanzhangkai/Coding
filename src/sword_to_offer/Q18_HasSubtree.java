package sword_to_offer;

/**
 * 树的子结构:
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * 思路：递归判断是否含有。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/13 21:24
 */
public class Q18_HasSubtree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //第一个递归，判断是否含有子树的根结点
    public static boolean hasSubtree(TreeNode node1, TreeNode node2) {
        boolean isHas = false;
        if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                isHas = doesHasSubtree(node1, node2);
            }
            //如果没找到,就去遍历根结点的左侧
            if (!isHas) {
                isHas = hasSubtree(node1.left, node2);
            }
            //如果还没找到，再遍历根节点的右侧
            if (!isHas) {
                isHas = hasSubtree(node1.right, node2);
            }
        }
        return isHas;
    }

    //第二个递归，确定两树的根结点左右val都相等才返回true
    public static boolean doesHasSubtree(TreeNode node1, TreeNode node2) {
        //node2先null,说明子树判断完了，返回true
        if (node2 == null) {
            return true;
        }
        //node1先出现null，已经确定不可能含有子树了，直接反悔false
        if (node1 == null) {
            return false;
        }
        //值相等
        if (node1.val != node2.val) {
            return false;
        }
        //两树的左边和两树的右边都相等才返回true
        return doesHasSubtree(node1.left, node2.left) && doesHasSubtree(node1.right, node2.right);
    }

}