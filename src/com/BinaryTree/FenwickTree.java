package com.BinaryTree;

public class FenwickTree {
    public int getParent(int index) {
        return index - (index & -index);
    }

    public int getNext(int index) {
        return index + (index & -index);
    }

    public int[] createTree(int[] input) {
        int n = input.length;
        int[] BITree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            updateTree(BITree, input[i - 1], i);
        }
        return BITree;
    }

    public void updateTree(int[] BITree, int val, int index) {
        while (index < BITree.length) {
            BITree[index] += val;
            index = getNext(index);
        }
    }

    public int getSum(int[] BITree, int index) {
        int sum = 0;
        index = index + 1;
        while (index > 0) {
            sum += BITree[index];
            index = getParent(index);
        }
        return sum;
    }

    public static void main(String[] args) {
        int input[] = {1,2,3,4,5,6,7};
        FenwickTree ft = new FenwickTree();
        int binaryIndexedTree[] = ft.createTree(input);
        System.out.println(ft.getSum(binaryIndexedTree, 0)); //1
        System.out.println(ft.getSum(binaryIndexedTree, 1)); //3
        System.out.println(ft.getSum(binaryIndexedTree, 2)); //6
        System.out.println(ft.getSum(binaryIndexedTree, 3)); //10
        System.out.println(ft.getSum(binaryIndexedTree, 4)); //15
        System.out.println(ft.getSum(binaryIndexedTree, 5)); //21
        System.out.println(ft.getSum(binaryIndexedTree, 6)); //28
    }
}
