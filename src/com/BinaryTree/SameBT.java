package com.BinaryTree;

public class SameBT {
    public static boolean areSameBT(Node head1, Node head2) {
        if (head1 == null && head2 == null)
            return true;
        if (head1 == null || head2 == null)
            return false;
        return (head1.data == head2.data) && areSameBT(head1.left, head2.left) && areSameBT(head1.right, head2.right);
    }

    public static void main(String[] args) {
        BinaryTree bt1 = new BinaryTree();
        Node head1 = null;
        head1 = bt1.addNode(10, head1);
        head1 = bt1.addNode(15, head1);
        head1 = bt1.addNode(5, head1);
        head1 = bt1.addNode(7, head1);
        head1 = bt1.addNode(19, head1);
        head1 = bt1.addNode(20, head1);
        head1 = bt1.addNode(-1, head1);
        head1 = bt1.addNode(21, head1);

        BinaryTree bt2 = new BinaryTree();
        Node head2 = null;
        head2 = bt2.addNode(10, head2);
        head2 = bt2.addNode(15, head2);
        head2 = bt2.addNode(5, head2);
        head2 = bt2.addNode(7, head2);
        head2 = bt2.addNode(19, head2);
        head2 = bt2.addNode(20, head2);
        head2 = bt2.addNode(1, head2);
        head2 = bt2.addNode(21, head2);

        System.out.println(areSameBT(head1, head2));
    }
}
