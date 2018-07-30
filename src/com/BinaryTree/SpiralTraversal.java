package com.BinaryTree;

import java.util.Stack;

public class SpiralTraversal {
    public static void spiral(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);

        while (!(s1.isEmpty() && s2.isEmpty())) {
            while (!s1.isEmpty()) {
                Node curr = s1.pop();
                System.out.print(curr.data + " ");
                if (curr.left != null) s2.push(curr.left);
                if (curr.right != null) s2.push(curr.right);
            }
            while (!s2.isEmpty()) {
                Node curr = s2.pop();
                System.out.print(curr.data + " ");
                //first right then left
                if (curr.right != null) s1.push(curr.right);
                if (curr.left != null) s1.push(curr.left);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(20, root);
        root = bt.addNode(30, root);
        root = bt.addNode(15, root);
        root = bt.addNode(-10, root);
        root = bt.addNode(0, root);
        root = bt.addNode(5, root);
        root = bt.addNode(-5, root);
        root = bt.addNode(-15, root);
        root = bt.addNode(27, root);
        root = bt.addNode(35, root);

        spiral(root);
        System.out.println();
    }
}
