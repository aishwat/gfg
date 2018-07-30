package com.BinaryTree;

import java.util.Stack;

public class IterativeTreeTraversals {
    public static void postOrder(Node head) {
        if (head == null) return;
        //push left then right , 2stacks
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            Node n = s1.pop();
            s2.push(n);
            if (n.left != null) s1.push(n.left);
            if (n.right != null) s1.push(n.right);
        }
        while (!s2.isEmpty()) {
            System.out.printf(s2.pop().data + " ");
        }
    }

    public static void preOrder(Node head) {
        if (head == null) return;
        //another approach is to keep 2 stacks, push all left on s1 and all right on s2, at each node. if left empty start using right
        //push right then left, 1 stack
        Stack<Node> s = new Stack<>();
        s.push(head);
        while (!s.isEmpty()) {
            Node n = s.pop();
            System.out.printf(n.data + " ");
            if (n.right != null) s.push(n.right);
            if (n.left != null) s.push(n.left);
        }
    }

    public static void inOrder(Node root) {
        if (root == null) return;

        Stack<Node> s = new Stack<>();
        while (true) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                if (s.isEmpty()) break;
                root = s.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        //remember stack is LIFO, so in vertical box rep, push also from top and pop also from top
        //stack drum, queue pipe
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(6, head);
        head = bt.addNode(3, head);
        head = bt.addNode(11, head);
        head = bt.addNode(10, head);
        head = bt.addNode(12, head);
        head = bt.addNode(2, head);
        head = bt.addNode(4, head);
        head = bt.addNode(5, head);
//        postOrder(head); // 2,5,4,3,10,12,11,6
//        System.out.println();
//        preOrder(head); // 6,3,2,4,5,11,10,12
//        System.out.println();
        inOrder(head); // 2,3,4,5,6,10,11,12
        System.out.println();
    }
}
