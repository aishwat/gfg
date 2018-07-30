package com.BinaryTree;

class Tuple {
    Boolean isBST;
    Integer size, min, max;

    public Tuple(Boolean isBST, Integer size, Integer min, Integer max) {
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "isBST:" + this.isBST + " size:" + size + " min:" + min + " max:" + max;
    }
}

public class LargestBSTinBT {
    public static Tuple getLargestBST(Node root) {
        if (root == null) {
            return new Tuple(true, 0, 0, 0);
        }
        if (root.left == null && root.right == null) { //leaf
            return new Tuple(true, 1, root.data, root.data);
        }
        Tuple left = getLargestBST(root.left);
        Tuple right = getLargestBST(root.right);

        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int min = root.data, max = root.data;
            if (root.left != null)
                min = left.min;
            if (root.right != null)
                max = right.max;
            return new Tuple(true, left.size + right.size + 1, min, max);

        } else {
            return new Tuple(false, Math.max(left.size, right.size), 0, 0);
        }
    }

    public static void main(String[] args) {
        ConstructTreeFromInOrderPreOrder ctf = new ConstructTreeFromInOrderPreOrder();
        //this is just to create a binary tree.
        int inorder[] = {-7, -6, -5, -4, -3, -2, 1, 2, 3, 16, 6, 10, 11, 12, 14};
        int preorder[] = {3, -2, -3, -4, -5, -6, -7, 1, 2, 16, 10, 6, 12, 11, 14};
        Node root = ctf.createTree(inorder, preorder);
        System.out.println(getLargestBST(root));

    }
}

class ConstructTreeFromInOrderPreOrder {

    private int index = 0;

    public Node createTree(int inorder[], int preorder[]) {
        Node result = createTree(inorder, preorder, 0, inorder.length - 1);
        index = 0;
        return result;
    }

    private Node createTree(int inorder[], int preorder[], int start, int end) {
        if (start > end) {
            return null;
        }
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[index] == inorder[i]) {
                break;
            }
        }
        Node node = Node.newNode(preorder[index]);
        index++;
        node.left = createTree(inorder, preorder, start, i - 1);
        node.right = createTree(inorder, preorder, i + 1, end);
        return node;
    }
}

