package it.pers.raza.common;

/**
 * @author gcystart
 * @Description 节点结构创建
 * @date
 */

public class BinTreeNode<Character> {

    public char val;
    public BinTreeNode<Character> lchild;
    public BinTreeNode<Character> rchild;//树的左孩子，右孩子

    public BinTreeNode(char val, BinTreeNode<Character> lchild, BinTreeNode<Character> rchild) {
        this.val = val;
        this.lchild = lchild;
        this.rchild = rchild;
    }

}
