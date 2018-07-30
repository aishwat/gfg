package com.BinaryTree;

class Node {
    int data;
    Node left, right;

    public static Node newNode(int data) {
        Node n = new Node();
        n.data = data;
        n.left = null;
        n.right = null;
        return n;
    }
}

public class BinaryTree {
    public Node addNode(int data, Node head) {
        Node tempHead = head; //just for init
        Node n = Node.newNode(data);
        if (head == null) {
            head = n;
            return head;
        }
        Node prev = null;
        while (head != null) {
            prev = head;
            if (head.data < data) {
                head = head.right;
            } else {
                head = head.left;
            }
        }
        if (prev.data < data) {
            prev.right = n;
        } else {
            prev.left = n;
        }
        return tempHead;
    }

    public static int size(Node head) {
        if (head == null)
            return 0;
        int left = size(head.left);
        int right = size(head.right);
        return left + right + 1;
    }

    public static int height(Node head) {
        if (head == null)
            return 0;
        int leftHeight = height(head.left);
        int rightHeight = height(head.right);
        return 1 + Math.max(leftHeight, rightHeight);
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
        System.out.println("size: " + size(head));
        System.out.println("height: " + height(head));
    }

}
