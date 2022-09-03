package it.pers.raza;

import it.pers.raza.common.BinTreeNode;
import it.pers.raza.common.BinTreeUtil;

import java.util.ArrayList;
import java.util.List;

public class DecompositionTraversal {
    public static void main(String[] args) {
        BinTreeNode<Character> binTree = BinTreeUtil.createBinTree();
        List<Character> characters = preorderTraverse(binTree);
        System.out.println(characters);
    }

   static List<Character> preorderTraverse(BinTreeNode<Character> binTree) {
        List<Character> res = new ArrayList<>();
        if (binTree == null) {
            return res;
        }
        res.add(binTree.val);
        res.addAll(preorderTraverse(binTree.lchild));
        res.addAll(preorderTraverse(binTree.rchild));
        return res;
    }
}
