package Graphs;

import java.util.*;

public class kruskal {
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

    public static void createGraph(ArrayList<Edge> graph) {

        // edges
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));
    }

    // for cycle detection verification in kruskal we use disjoint union
    static int n = 4;// vertices
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

        return par[x] = find(par[x]);// optimization
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

    public static void kruskal(ArrayList<Edge> graph, int v) {// O(V)+o(ElogE)
        init();
        Collections.sort(graph);// O(ElogE)
        int count = 0, mstCost = 0;

        // O(V)
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
        int v = 4;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        kruskal(graph, v);
    }
}
