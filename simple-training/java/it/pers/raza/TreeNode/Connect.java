package it.pers.raza.TreeNode;

import it.pers.raza.common.Node;
import it.pers.raza.common.NodeUtil;

public class Connect {

    public static void main(String[] args) {
        Node binTree = NodeUtil.createTwoXTree();
        connect(binTree);
    }

    public static Node connect(Node root) {
        traverse(root);
        return null;
    }

    static void traverse(Node root) {
        if (root == null) {
            return;
        }
        // 前序位置
        traverse(root.left);
        System.out.println("left:" + root.left + "right:" + root.right + "root:" + root.val);
        // 中序位置
        traverse(root.right);
        // 后序位置
    }
}
