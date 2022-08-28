package it.pers.raza;

/**
 * @author gcystart
 * @Description 节点结构创建
 * @date
 */

public class BinTreeNode<Character> {

    char val;
    BinTreeNode<Character> lchild, rchild;//树的左孩子，右孩子

    BinTreeNode(char val, BinTreeNode<Character> lchild, BinTreeNode<Character> rchild) {
        this.val = val;
        this.lchild = lchild;
        this.rchild = rchild;
    }

}
