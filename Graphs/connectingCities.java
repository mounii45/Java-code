package Graphs;

import java.util.*;

// METHOD 1 --> KRUSKAL ALGORITHM

public class connectingCities {

    static class Edge implements Comparable<Edge> {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph, int[][] cities) {

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[i].length; j++) {

                if (j > i && cities[i][j] != 0) // j>i because duplicates are added which are of no use
                    graph.add(new Edge(i, j, cities[i][j]));
            }
        }
    }

    static int n = 5;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {// provides top root at position of parent
        if (par[x] == x)
            return x;

        return find(par[x]);
    }

    public static void union(int a, int b) {

        int parA = find(a), parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;// leaders leader
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;// no updation of rank
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskal(ArrayList<Edge> graph, int v) {
        init();
        Collections.sort(graph);
        int count = 0, mstCost = 0;

        for (int i = 0; count < v - 1; i++) {// i traverse to every edge & c for count of vertices to stop
            Edge e = graph.get(i);

            int parA = find(e.src), parB = find(e.dest);
            if (parA != parB) { // no cycle
                union(e.src, e.dest);// join those edges
                mstCost += e.wt;
                count++; // to verify all vertices are included
            }
        }

        System.out.println("min cost to connect cities " + mstCost);
    }

    public static void main(String[] args) {
        int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };
        int v = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph, cities);
        kruskal(graph, v);

    }
}

// METHOD 2 --> PRIMS ALGORITHM

/*
 * import java.util.ArrayList;
 * import java.util.PriorityQueue;
 * 
 * public class connectingCities {
 * 
 * static class Edge {
 * int src, dest, wt;
 * 
 * public Edge(int s, int d, int w) {
 * this.src = s;
 * this.dest = d;
 * this.wt = w;
 * }
 * }
 * 
 * public static void createGraph(ArrayList<Edge>[] graph, int[][] cities) {
 * for (int i = 0; i < graph.length; i++) {
 * graph[i] = new ArrayList<>();// inner list initialization
 * 
 * }
 * 
 * for (int i = 0; i < cities.length; i++) {
 * for (int j = 0; j < cities[i].length; j++) {
 * if (cities[i][j] != 0)
 * graph[i].add(new Edge(i, j, cities[i][j]));
 * }
 * }
 * }
 * 
 * static class pair implements Comparable<pair> {
 * int n;
 * int cost;
 * 
 * public pair(int n, int cost) {
 * this.n = n;
 * this.cost = cost;
 * }
 * 
 * @Override
 * public int compareTo(pair p2) {
 * return this.cost - p2.cost; // path based sorting for my pairs
 * }
 * 
 * }
 * 
 * public static void prims(ArrayList<Edge>[] graph) {
 * PriorityQueue<pair> pq = new PriorityQueue<>();
 * boolean[] vis = new boolean[graph.length];
 * pq.add(new pair(0, 0));
 * int minCost = 0;
 * 
 * while (!pq.isEmpty()) {
 * pair curr = pq.remove();
 * 
 * if (!vis[curr.n]) {
 * vis[curr.n] = true;
 * minCost += curr.cost;
 * for (int i = 0; i < graph[curr.n].size(); i++) {
 * Edge e = graph[curr.n].get(i);
 * pq.add(new pair(e.dest, e.wt));
 * }
 * }
 * }
 * 
 * System.out.println("min cost to connect cities " + minCost);
 * 
 * }
 * 
 * public static void main(String[] args) {
 * int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, {
 * 3, 0, 6, 0, 0 },
 * { 4, 7, 0, 0, 0 } };
 * int v = 5;
 * ArrayList<Edge>[] graph = new ArrayList[v];
 * createGraph(graph, cities);
 * prims(graph);
 * 
 * }
 * }
 * 
 */