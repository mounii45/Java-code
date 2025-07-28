package priorityQueuesB;

import java.util.*;

public class nearByCars {
    static class point implements Comparable<point> {
        int x, y, sqDist, idx;

        public point(int x, int y, int sqDist, int idx) {
            this.x = x;
            this.y = y;
            this.sqDist = sqDist;
            this.idx = idx;
        }

        @Override
        public int compareTo(point p2) {
            return this.sqDist - p2.sqDist;// ascending order
        }
    }

    public static void main(String[] args) {

        PriorityQueue<point> pq = new PriorityQueue<>();
        int arr[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        for (int i = 0; i < arr.length; i++) {
            int sqDist = arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1];
            pq.add(new point(arr[i][0], arr[i][1], sqDist, i));
        }

        System.out.println("Nearest k cars");
        for (int i = 0; i < k; i++) {
            System.out.print("C" + pq.remove().idx + " ");

        }
    }
}
