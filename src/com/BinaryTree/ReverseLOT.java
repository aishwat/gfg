package com.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLOT {
    public static void revLvlOrderTrav(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            stack.push(curr);
            if(curr.right !=null) queue.add(curr.right);
            if(curr.left !=null) queue.add(curr.left);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().data+" ");
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

        revLvlOrderTrav(root);
        System.out.println();
    }
}
