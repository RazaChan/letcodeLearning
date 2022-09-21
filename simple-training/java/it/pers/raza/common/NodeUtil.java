package it.pers.raza.common;

public class NodeUtil {
    public static Node createBinTree() {
        //<Character>:泛型：优点是保证类型的安全
        Node RR2 = new Node('F', null, null);
        Node LR2 = new Node('E', null, null);
        Node LL2 = new Node('D', null, null);
        Node L1 = new Node('B', LL2, LR2);
        Node R1 = new Node('C', null, RR2);
        Node node = new Node('A', L1, R1);
        return node;
    }

    public static Node createTwoXTree() {
        //<Character>:泛型：优点是保证类型的安全
        Node RR2 = new Node('F', null, null);
        Node RL2 = new Node('G', null, null);
        Node LR2 = new Node('E', null, null);
        Node LL2 = new Node('D', null, null);
        Node L1 = new Node('B', LL2, LR2);
        Node R1 = new Node('C', RL2, RR2);
        Node node = new Node('A', L1, R1);
        return node;
    }
}
