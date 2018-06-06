package com.leet;

import java.util.*;

public class ConvexHull {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return("(" + this.x + " " + this.y + ")");
        }
    }

    private int crossProduct(Point a, Point b, Point c) {
        //y2x1-y1x2
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        return (y2 * x1) - (y1 * x2);
    }

    //Returns < 0 if 'b' is closer to 'a' compared to 'c', 0 otherwise
    private int getDistance(Point a, Point b, Point c) {
        int dist_ab = (b.y - a.y) ^ 2 + (b.x - a.x) ^ 2;
        int dist_ac = (c.y - a.y) ^ 2 + (c.x - a.x) ^ 2;
        if (dist_ab == dist_ac)
            return 0;
        return (dist_ab < dist_ac) ? -1 : 1;
    }

    private List<Point> getConvexHull(Point[] points) {
        //first get left most point
        Point start = points[0];
        for (int i = 1; i < points.length; i++) {
            if (start.x > points[i].x)
                start = points[i];
        } //start could be any nth point, and code assuming that

        Point current = start;
        Set<Point> result = new HashSet<>();
        result.add(start);
        List<Point> collinearPoints = new ArrayList<>();

        //3 point needed, which are
        // current, nextTarget, points[i]
        while (true) {
            //cuurent nth point, nextTarget 0th point //then start iterating
            Point nextTarget = points[0];
            for (int i = 1; i < points.length; i++) {
                if (current == points[i])
                    continue;

                int val = crossProduct(current, nextTarget, points[i]);
                if (val > 0) {
                    //point[i] is on left
                    nextTarget = points[i];
                    collinearPoints = new ArrayList<>();
                } else if (val == 0) {
                    //check whichever is closer, put that in collinear points and other one as target
                    if (getDistance(current, nextTarget, points[i]) < 0) //b is closer < 0
                    {
                        collinearPoints.add(nextTarget);
                        nextTarget = points[i];
                    } else {
                        collinearPoints.add(points[i]);
                    }
                }
                //if val < 0 , on right, do nothing
            }
            for (Point p : collinearPoints) {
                result.add(p);
            }
            if (nextTarget == start)
                break;

            result.add(nextTarget);
            current = nextTarget;
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        ConvexHull ch = new ConvexHull();
        Point[] points = new Point[6];
        points[0] = new Point(1, 1);
        points[1] = new Point(2, 2);
        points[2] = new Point(2, 0);
        points[3] = new Point(2, 4);
        points[4] = new Point(3, 3);
        points[5] = new Point(4, 2);
        List<Point> result = ch.getConvexHull(points);
        System.out.println(Arrays.toString(result.toArray()));

    }
}


