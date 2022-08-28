package it.pers.raza;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author gs🐏
 * @version 1.0
 * @describe
 * @date
 */

public class BinTreeTraversal {
    //测试
    public static void main(String[] args) {

        Traversal traversal = new Traversal();

        System.out.print("前序遍历：");
        System.out.println(traversal.preOrder());

        System.out.print("中序遍历:");
        System.out.println(traversal.inOrder());

        System.out.print("后序遍历:");
        System.out.println(traversal.postOrder());
    }

}

class Traversal {

    /**
     * @return 根节点
     * @Description 创建一棵二叉树
     * @author gcystart
     * @date
     */
    public static BinTreeNode<Character> createBinTree() {
        //<Character>:泛型：优点是保证类型的安全
        BinTreeNode<Character> RR2 = new BinTreeNode<>('F', null, null);
        BinTreeNode<Character> LR2 = new BinTreeNode<>('E', null, null);
        BinTreeNode<Character> LL2 = new BinTreeNode<>('D', null, null);
        BinTreeNode<Character> L1 = new BinTreeNode<>('B', LL2, LR2);
        BinTreeNode<Character> R1 = new BinTreeNode<>('C', null, RR2);
        BinTreeNode<Character> node = new BinTreeNode<>('A', L1, R1);
        return node;
    }

    // 前序遍历

    public List<Character> premine() {
        BinTreeNode<Character> binTree = createBinTree();
        List<Character> result = new ArrayList<>();
        Stack<BinTreeNode<Character>> stack = new Stack<>();
        while (binTree != null) {
            while (binTree != null) {
                result.add(binTree.val);
                stack.push(binTree);
                binTree = binTree.lchild;
            }
            binTree = stack.pop();
            binTree = binTree.rchild;
        }
        return result;
    }


    /*
    前序遍历：迭代法
     */
    public List<Character> preOrder() {

        BinTreeNode<Character> root = createBinTree(); //根节点root

        List<Character> res = new ArrayList<>(); //创建一个队列，用来返回
        Stack<BinTreeNode<Character>> stack = new Stack<>(); //创建一个栈

        //迭代访问节点的左孩子，并入栈
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.lchild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点的右孩子
            root = stack.pop();
            root = root.rchild;
        }

        return res;
    }


    /*
    中序迭代法
     */
    public List<Character> inOrder() {

        BinTreeNode<Character> root = createBinTree();

        List<Character> res = new ArrayList<>();
        Stack<BinTreeNode<Character>> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.lchild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，并将弹出的的节点加入到res中。访问节点的右孩子
            root = stack.pop();
            res.add(root.val);
            root = root.rchild;
        }

        return res;
    }


    /*
    后序迭代法
     */
    public List<Character> postOrder() {

        BinTreeNode<Character> root = createBinTree();

        BinTreeNode<Character> prevAccess = null;

        List<Character> res = new ArrayList<>();
        Stack<BinTreeNode<Character>> stack = new Stack<BinTreeNode<Character>>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.lchild;
            }
            root = stack.pop();
            if (root.rchild == null || root.rchild == prevAccess) {
                res.add(root.val);
                prevAccess = root;
                root = null;
            } else {
                stack.push(root);
                root = root.rchild;
            }
        }

        return res;
    }

}