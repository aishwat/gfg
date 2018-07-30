package com.BinaryTree;

public class RootToLeafSum {
    //given a sum, find if any path from root to leaf has that sum
    public static boolean isRTLSum(Node head, int sum) {
        if (head == null)
            return false;
        if (head.left == null && head.right == null && head.data == sum) {//if leaf node and data same as remainder sum
            return true;
        }
        else if (head.left == null && head.right == null && head.data != sum) {
            return false;
        }
        boolean left = false, right = false;

        if (head.left != null) {
            left = isRTLSum(head.left, sum - head.data);
        }
        if (head.right != null) {
            right = isRTLSum(head.right, sum - head.data);
        }
        return left || right;
    }

    //later refactor to get path, basically path.add, whenever returning true
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(16, head);
        head = bt.addNode(5, head);
        head = bt.addNode(-3, head);
        head = bt.addNode(6, head);
//        head = bt.addNode(11, head);
        System.out.println(isRTLSum(head, 26));
    }
}
