package com.leet;

import java.util.*;

public class Skyline {
    public enum StartEnd {S, E}

    ;

    static class BuildingPoint implements Comparable<BuildingPoint> {
        int x, y;
        StartEnd SE;

        @Override
        public int compareTo(BuildingPoint o) {
            if (this.x != o.x) {
                //sort on x
                return this.x - o.x;
            } else {
                //tie breakers
                if (this.SE == StartEnd.S && o.SE == StartEnd.S) {
                    //both start, higher height first
                    return -(this.y - o.y);
                }
                if (this.SE == StartEnd.E && o.SE == StartEnd.E) {
                    //both end, lower height first
                    return (this.y - o.y);
                } else {
                    //one start, other end : start of next building comes first
                    return (this.SE == StartEnd.S ? -1 : 1);
                }
            }
        }

        @Override
        public String toString() {
            return this.x+" "+this.y+" "+ (SE==StartEnd.S?'S':'E');
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for (int building[] : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].y = building[2];
            buildingPoints[index].SE = StartEnd.S;

            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].y = building[2];
            buildingPoints[index + 1].SE = StartEnd.E;

            index += 2;
        }
        Arrays.sort(buildingPoints);
        System.out.printf(Arrays.toString(buildingPoints));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(0);
        int prevMaxHeight = 0;
        List<int[]> result = new ArrayList<>();
        for (BuildingPoint buildingPoint : buildingPoints) {
            if (buildingPoint.SE == StartEnd.S) {
                //if start, add to queue
                queue.add(buildingPoint.y);
            }
            if (buildingPoint.SE == StartEnd.E) {
                //if end, remove from queue
                queue.remove(buildingPoint.y);
            }
            int currHeight = queue.peek();
            //if height changes update in result
            if (prevMaxHeight != currHeight) {
                result.add(new int[]{buildingPoint.x, currHeight});
                prevMaxHeight = currHeight;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[][] buildings = {{1, 3, 4}, {3, 4, 4}, {2, 6, 2}, {8, 11, 4}, {7, 9, 3}, {10, 11, 2}};
//        int[][] buildings = {{1, 3, 4}, {2, 4, 4}, {5, 8, 2}, {6, 7, 4}, {8, 9, 4}};
        Skyline sk = new Skyline();
        List<int[]> criticalPoints = sk.getSkyline(buildings);
        System.out.println();
        criticalPoints.forEach(cp -> System.out.println(cp[0] + " " + cp[1]));

    }
}
