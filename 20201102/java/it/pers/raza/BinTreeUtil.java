package it.pers.raza;

public class BinTreeUtil {
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
}
