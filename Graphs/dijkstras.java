package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstras {

    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();// inner list initialization

        }

        // AL -> we use add function

        // unweighted graph.but to maintain the standard we keep the weight as 1
        graph[0].add(new Edge(0, 1, 2)); // only 1
        graph[0].add(new Edge(0, 2, 4));

        // 1 vertex
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        // 2 vertex
        graph[2].add(new Edge(2, 4, 3));

        // 3 vertex
        graph[3].add(new Edge(3, 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 5, 5));
        graph[4].add(new Edge(4, 3, 2));

    }

    static class pair implements Comparable<pair> {
        int n;
        int path;

        public pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(pair p2) {
            return this.path - p2.path; // path based sorting for my pairs
        }

    }

    public static void dijkstrasAlgor(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];// dist[i] :src->i
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;// initially infinity is assigned to eaach node distance from src
            }
        }

        boolean vis[] = new boolean[graph.length];

        PriorityQueue<pair> pq = new PriorityQueue<>();// in asc order
        pq.add(new pair(src, 0));// 0-> 0

        while (!pq.isEmpty()) {
            pair curr = pq.remove();
            if (!vis[curr.n]) {// value of that pair class curr
                // neighbors
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) { // update the distance of src to v
                        dist[v] = dist[u] + wt;
                        pq.add(new pair(v, dist[v]));
                    }

                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        dijkstrasAlgor(graph, 0);
    }
}
