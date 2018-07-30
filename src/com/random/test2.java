package com.random;

import java.util.ArrayList;
import java.util.Arrays;

public class test2 {
    static class Node implements Comparable<Node> {
        String name;
        Integer rollNo;
        Integer mark;

        public Node(String name, Integer rollNo, Integer mark) {
            this.name = name;
            this.rollNo = rollNo;
            this.mark = mark;
        }

        @Override
        public int compareTo(Node o) {
            if (o.mark != this.mark)
                return o.mark - this.mark;
            else if (o.name != this.name)
                return -(o.name.compareToIgnoreCase(this.name));
            else
                return o.rollNo - this.rollNo;
        }

        @Override
        public String toString() {
            return rollNo + " " + name;
        }
    }

    public static void main(String[] args) {
        Node tuple1 = new Node("Luna", 356, 35);
        Node tuple2 = new Node("Ron Weasley", 289, 35);
        Node tuple3 = new Node("Hermoine grange", 533, 36);
        Node[] nodes = new Node[3];
        nodes[0] = tuple1;
        nodes[1] = tuple2;
        nodes[2] = tuple3;
        Arrays.sort(nodes);
        System.out.println(Arrays.toString(nodes));
    }
}
