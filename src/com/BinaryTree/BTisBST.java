package com.BinaryTree;

public class BTisBST {
    public static boolean isBST(Node head, int min, int max) {
        if (head == null)
            return true;
        if (head.data < min || head.data > max)
            return false;


        return isBST(head.left, min, head.data) && isBST(head.right, head.data, max);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(19, head);
        head = bt.addNode(20, head);
        head = bt.addNode(-1, head);
        head = bt.addNode(21, head);
        System.out.println(isBST(head, -999, 999));
    }
}

