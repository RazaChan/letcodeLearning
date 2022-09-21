package it.pers.raza.bsfdfs;

import it.pers.raza.common.TreeNode;

public class MergeTrees {
    /**
     * 给你两棵二叉树： root1 和 root2 。
     * <p>
     * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
     * <p>
     * 返回合并后的二叉树。
     * <p>
     * 注意: 合并过程必须从两个树的根节点开始。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/merge-two-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root1
     * @param root2
     * @return
     */

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(2, null, null));
        TreeNode treeNode2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4, null, null)), new TreeNode(3, null, new TreeNode(7, null, null)));
        TreeNode treeNode = mergeTrees(treeNode1, treeNode2);
        System.out.println(treeNode);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return root1;
        } else if (root1 == null && root2 != null) {
            root1 = root2;
            return root1;
        } else if (root1 != null && root2 == null) {
            return root1;
        } else {
            root1.val = root1.val + root2.val;
        }
        mergeTrees(root1.left, root2.left);
        mergeTrees(root1.right, root2.right);
        return root1;
    }
}
