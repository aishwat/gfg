package com.dynamic;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class PolygonTriangulation {
    public static Double getDist(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }

    public static Double getTriangleCost(Point p1, Point p2, Point p3) {
        return getDist(p1, p2) + getDist(p2, p3) + getDist(p3, p1);
    }

    public static void getMinCostPolygonTriangulation(Point[] points) {
        int n = points.length;
        Double T[][] = new Double[n][n];

        for (int i = 0; i < n; i++) {
            T[i][i] = 0.0; //l=0
        }
        for (int i = 0; i < n - 1; i++) {
            T[i][i + 1] = 0.0; //l=1
        }
        for (int l = 2; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                int j = i + l;
                for (int k = i + 1; k < j; k++) {
                    T[i][j] = 999.0;
                    T[i][j] = Math.min(T[i][j], T[i][k] + T[k][j] + getTriangleCost(points[i], points[k], points[j]));
                }
            }
        }
        printArr(T);
    }

    public static void printArr(Double T[][]) {
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T.length; j++) {
                System.out.printf("%.1f\t", T[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Point points[] = {new Point(0, 0),
                new Point(1, 0),
                new Point(2, 1),
                new Point(1, 2),
                new Point(0, 2)};
        getMinCostPolygonTriangulation(points);
    }
}
