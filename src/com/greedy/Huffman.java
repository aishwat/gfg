package com.greedy;

import com.graphs.StringCircle;

import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode>{
    int freq;
    char c;
    HuffmanNode left;
    HuffmanNode right;

    @Override
    public int compareTo(HuffmanNode o) {
        return this.freq - o.freq;
    }

    public String toString() {
        return this.c + ": " + Integer.toString(this.freq);
    }
}

public class Huffman {
    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && root.c != '-') {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + '0');
        printCode(root.right, s + '1');
    }

    public static void main(String[] args) {
        int[] charFreq = {5, 9, 12, 13, 16, 45};
        char[] charArr = {'a', 'b', 'c', 'd', 'e', 'f'};

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();

        for (int i = 0; i < charArr.length; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.freq = charFreq[i];
            hn.c = charArr[i];
            queue.add(hn);
        }

        HuffmanNode root = null;
        //we use min heap to construct huffman tree
        //but huffman itself is max heap
        while (queue.size() > 1) {
            HuffmanNode x = queue.poll();
            HuffmanNode y = queue.poll();

            HuffmanNode hn = new HuffmanNode();
            hn.c = '-';
            hn.freq = x.freq + y.freq;
            hn.left = x;
            hn.right = y;

            root = hn;

            queue.add(hn);
        }

        printCode(root, "");
    }

}
