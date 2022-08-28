package it.pers.raza;

public class MaxDep {
    static int maxDep = 0;
    static int dep = 0;

    public static void main(String[] args) {
        BinTreeNode<Character> binTree = BinTreeUtil.createBinTree();
        traverse(binTree);
        System.out.println(maxDep);
        int i = traverse1(binTree);
        System.out.println(i);
    }

    // 遍历一遍对应回溯算法框架，本质是暴力穷举
    static void traverse(BinTreeNode<Character> binTree) {
        if (binTree == null) {
            return;
        }
        dep++;
        // 当左右节点都不存在的时候就表示便利完成了
        if (binTree.rchild == null && binTree.lchild == null) {
            maxDep = Math.max(dep, maxDep);
        }
        traverse(binTree.lchild);
        traverse(binTree.rchild);
        dep--;
    }

    //分解问题思路对应动态规划，转化为子树的最大深度
    static int traverse1(BinTreeNode<Character> binTree) {
        if (binTree == null) {
            return 0;
        }
        int rDep = traverse1(binTree.rchild);
        int lDep = traverse1(binTree.lchild);
        return Math.max(rDep, lDep) + 1;
    }
}
