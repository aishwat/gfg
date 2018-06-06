package com.leet;

//Lowest common ancestor binary search tree

class Node {
    int key;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}


public class LCA_BST {
    Node root;

    public Node getLCA(Node root, int n1, int n2) {
        if (root == null)
            return null;

        if (root.key < n1 && root.key < n2)
            return getLCA(root.right, n1, n2);
        if (root.key > n1 && root.key > n2)
            return getLCA(root.left, n1, n2);

        return root; //must be equal //or root.key<n1 && root.key>n2 // or vice versa
    }

    public static void main(String[] args) {
        LCA_BST bst = new LCA_BST();
        bst.root = new Node(10);
        bst.root.left = new Node(-10);
        bst.root.left.right = new Node(8);
        bst.root.left.right.left = new Node(6);
        bst.root.left.right.right = new Node(9);

        bst.root.right = new Node(30);
        bst.root.right.left = new Node(25);
        bst.root.right.left.right = new Node(28);
        bst.root.right.right = new Node(60);
        bst.root.right.right.right = new Node(78);
        Node LCA = bst.getLCA(bst.root, 28, 78);
        System.out.println(LCA.key);
        LCA = bst.getLCA(bst.root, 6, 30);
        System.out.println(LCA.key);
    }
}
