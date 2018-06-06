package com.leet;

//Lowest common ancestor binary search tree


public class LCA_BT {
    Node root;

    public Node getLCA(Node root, int n1, int n2) {
        Node left=null;
        Node right=null;
        if (root.key == n1 || root.key == n2)
            return root;
        if (root.left == null && root.right == null)
            return null;

        if (root.left != null)
            left = getLCA(root.left, n1, n2);
        if (root.right != null)
            right = getLCA(root.right, n1, n2);

        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        return (left != null) ? left : right;

//        return root; //must be equal //or root.key<n1 && root.key>n2 // or vice versa
    }

//    public static void main(String[] args) {
//        LCA_BT bst = new LCA_BT();
//        bst.root = new Node(3);
//        bst.root.left = new Node(6);
//        bst.root.left.left = new Node(2);
//        bst.root.left.right = new Node(11);
//        bst.root.left.right.left = new Node(9);
//        bst.root.left.right.right = new Node(5);
//
//        bst.root.right = new Node(8);
//        bst.root.right.right = new Node(13);
//        bst.root.right.right.left = new Node(7);
//        Node LCA = bst.getLCA(bst.root, 2, 5);
//        System.out.println(LCA.key);
////        LCA = bst.getLCA(bst.root, 6, 30);
////        System.out.println(LCA.key);
//    }
}
