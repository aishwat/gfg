package com.search_sort;


public class LinkedListMergeSort {
    Node head = null;

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    void push(int new_data) {
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
    }

    void printList(Node head) {
        System.out.println();
        while (head != null) {
            System.out.printf(String.valueOf(head.val) + "->");
            head = head.next;
        }
        System.out.printf("null");
    }

    public Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slowPtr = head;
        Node fastPtr = head.next;
        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            if (fastPtr != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
        }
        System.out.printf("\nmiddle " + slowPtr.val);
        return slowPtr;
    }

    public Node sortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.val < b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node middleNext = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(middleNext);

        Node sorted = sortedMerge(left, right);
        return sorted;
    }

    public static void main(String[] args) {
        LinkedListMergeSort linkedList = new LinkedListMergeSort();
        linkedList.push(15);
        linkedList.push(10);
        linkedList.push(5);
        linkedList.push(20);
        linkedList.push(3);
        linkedList.push(2);
        Node head = linkedList.head;
        linkedList.printList(head);
        Node sorted = linkedList.mergeSort(head);
        linkedList.printList(sorted);


    }

}
