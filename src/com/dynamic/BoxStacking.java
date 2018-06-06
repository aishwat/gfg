package com.dynamic;

import java.util.Arrays;

class Box implements Comparable<Box> {
    int l, w, h;

    Box(int l, int w, int h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    @Override
    public int compareTo(Box o) {
        return -((this.l * this.w) - (o.l * o.w)); //for decreasing
    }

    @Override
    public String toString() {
        return "Box l:" + this.l + " w:" + this.w + " h:" + this.h;
    }
}

public class BoxStacking {
    public static void getStack(Box[] boxes) {
        Box[] boxList = new Box[boxes.length * 3];
        for (int i = 0; i < boxes.length; i++) {
            Box box = boxes[i];
            boxList[3 * i] = box;
            boxList[3 * i + 1] = new Box(Math.max(box.w, box.h), Math.min(box.w, box.h), box.l);
            boxList[3 * i + 2] = new Box(Math.max(box.l, box.h), Math.min(box.l, box.h), box.w);
        }
        Arrays.sort(boxList);
        int T[] = new int[boxList.length];
        for (int i = 0; i < boxList.length; i++) {
            T[i] = boxList[i].h;
        }

        printBoxes(boxList);
        for (int i = 1; i < boxList.length; i++) {
            for (int j = 0; j < i; j++) {
                //smaller box on top of bigger
                if (boxList[i].l < boxList[j].l && boxList[i].w < boxList[j].w && T[i] < T[j] + boxList[i].h)
                    T[i] = T[j] + boxList[i].h;
            }
        }
        System.out.println(Arrays.toString(T));

    }

    public static void printBoxes(Box[] boxList) {
        for (int i = 0; i < boxList.length; i++) {
            System.out.println(i + " " + boxList[i].toString());
        }
    }

    public static void main(String[] args) {
        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);
        getStack(arr);
    }
}
