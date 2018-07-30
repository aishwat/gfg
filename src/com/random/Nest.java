package com.random;
import java.util.*;

public class Nest {
    static class Point {
        String att1;
        String att2;
        float val;

        Point(String att1, String att2, float val) {
            this.att1 = att1;
            this.att2 = att2;
            this.val = val;
        }

        @Override
        public String toString() {
            return att1+" "+att2+ " "+String.valueOf(val);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        int lines = in.nextInt();
        Point[] points = new Point[lines];

        for (int i = 0; i < lines; i++) {
            String s = in.next();
            String[] input = s.split(", ");
            points[i] = new Point(input[0].replace("\"",""), input[1].replace("\"",""), Float.parseFloat(input[2]));

        }
        float rb = in.nextFloat();

        for (int i = 0; i < lines; i++) {
            System.out.println(points[i].toString());
        }
//        Nest nest = new Nest();
//        Point[] points = new Point[6];
//        points[0] = new Point("Booking", "last bed", 10000);
//        points[1] = new Point("Booking", "any bed", 8000);
//        points[2] = new Point("Booking", "any bed", 6000);
//        points[3] = new Point("Booking", "last bed", 7000);
//        points[4] = new Point("House Visit", "new lead", 5);
//        points[5] = new Point("House Visit", "existing lead", 6);
//        float rb = (float) 4.8;

        float tbp = 0; //total bed point
        float hvp = 0; //house visit point
        int hv = 0; //total house visits
        //rating bonus
        float tp = 0; //total point
        for (Point point : points) {
            if (point.att1.equals("Booking") && point.att2.equals("last bed")) {
                tbp += 0.15 * point.val;
            }
            if (point.att1.equals("Booking") && point.att2.equals("any bed")) {
                tbp += 0.10 * point.val;
            }
            if (point.att1.equals("House Visit") && point.att2.equals("new lead")) {
                hvp += 1000 * point.val;
                hv += point.val;
            }
            if (point.att1.equals("House Visit") && point.att2.equals("existing lead")) {
                hvp += 700 * point.val;
                hv += point.val;
            }
        }
//        System.out.println("tbp"+tbp);
//        System.out.println("hvp"+hvp);
//        System.out.println("hv"+hv);
        if (hv > 30) {
            hvp += 0.10 * hvp;
        }
        if (hv >= 10 && hv <= 30) {
            hvp += 0.05 * hvp;
        }
        tp = tbp + hvp;

        if (rb > 4.5) {
            tp += 0.5 * tp;
        }

        System.out.println("tp"+tp);
    }

}
