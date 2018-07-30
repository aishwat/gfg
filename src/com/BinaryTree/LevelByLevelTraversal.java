package com.BinaryTree;

import java.util.LinkedList;

public class LevelByLevelTraversal {
    public static void lvlTraversal(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (true) {
            Node curr = queue.poll();
            if (curr == null && queue.size() == 0)
                break;
            if (curr == null) {
                System.out.println();
                queue.add(null);
            } else {
                System.out.printf(curr.data + " ");
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        //remember stack is LIFO, so in vertical box rep, push also from top and pop also from top
        //stack drum, queue pipe
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

        lvlTraversal(root);
        System.out.println();
    }
}
