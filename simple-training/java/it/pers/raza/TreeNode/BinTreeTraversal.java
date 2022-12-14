package it.pers.raza.TreeNode;

import it.pers.raza.common.BinTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author gsð
 * @version 1.0
 * @describe
 * @date
 */

public class BinTreeTraversal {
    //æµè¯
    public static void main(String[] args) {

        Traversal traversal = new Traversal();

        System.out.print("ååºéåï¼");
        System.out.println(traversal.preOrder());

        System.out.print("ä¸­åºéå:");
        System.out.println(traversal.inOrder());

        System.out.print("ååºéå:");
        System.out.println(traversal.postOrder());
    }

}

class Traversal {

    /**
     * @return æ ¹èç¹
     * @Description åå»ºä¸æ£µäºåæ 
     * @author gcystart
     * @date
     */
    public static BinTreeNode<Character> createBinTree() {
        //<Character>:æ³åï¼ä¼ç¹æ¯ä¿è¯ç±»åçå®å¨
        BinTreeNode<Character> RR2 = new BinTreeNode<>('F', null, null);
        BinTreeNode<Character> LR2 = new BinTreeNode<>('E', null, null);
        BinTreeNode<Character> LL2 = new BinTreeNode<>('D', null, null);
        BinTreeNode<Character> L1 = new BinTreeNode<>('B', LL2, LR2);
        BinTreeNode<Character> R1 = new BinTreeNode<>('C', null, RR2);
        BinTreeNode<Character> node = new BinTreeNode<>('A', L1, R1);
        return node;
    }

    // ååºéå

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
    ååºéåï¼è¿­ä»£æ³
     */
    public List<Character> preOrder() {

        BinTreeNode<Character> root = createBinTree(); //æ ¹èç¹root

        List<Character> res = new ArrayList<>(); //åå»ºä¸ä¸ªéåï¼ç¨æ¥è¿å
        Stack<BinTreeNode<Character>> stack = new Stack<>(); //åå»ºä¸ä¸ªæ 

        //è¿­ä»£è®¿é®èç¹çå·¦å­©å­ï¼å¹¶å¥æ 
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.lchild;
            }
            //å¦æèç¹æ²¡æå·¦å­©å­ï¼åå¼¹åºæ é¡¶èç¹ï¼è®¿é®èç¹çå³å­©å­
            root = stack.pop();
            root = root.rchild;
        }

        return res;
    }


    /*
    ä¸­åºè¿­ä»£æ³
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
            //å¦æèç¹æ²¡æå·¦å­©å­ï¼åå¼¹åºæ é¡¶èç¹ï¼å¹¶å°å¼¹åºççèç¹å å¥å°resä¸­ãè®¿é®èç¹çå³å­©å­
            root = stack.pop();
            res.add(root.val);
            root = root.rchild;
        }

        return res;
    }


    /*
    ååºè¿­ä»£æ³
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