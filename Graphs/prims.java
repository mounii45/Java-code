package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class prims {
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
        graph[0].add(new Edge(0, 1, 10)); // only 1
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        // 1 vertex
        graph[1].add(new Edge(1, 3, 40));
        graph[1].add(new Edge(1, 0, 10));

        // 2 vertex
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        // 3 vertex
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    static class pair implements Comparable<pair> {
        int n;
        int cost;

        public pair(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(pair p2) {
            return this.cost - p2.cost; // path based sorting for my pairs
        }

    }

    public static void prims(ArrayList<Edge>[] graph) {

        int minCost = 0;
        boolean vis[] = new boolean[graph.length];

        PriorityQueue<pair> pq = new PriorityQueue<>();// in asc order
        pq.add(new pair(0, 0));// 0-> 0

        while (!pq.isEmpty()) {
            pair curr = pq.remove();

            if (!vis[curr.n]) {// value of that pair class curr

                vis[curr.n] = true;
                minCost += curr.cost;// the 1st min cost in PQ

                // neighbors
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    pq.add(new pair(e.dest, e.wt));// put neighbours of selected ver in pa

                }

            }
        }

        System.out.println("minimum cost S.T through prims algorithm " + minCost);

    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        prims(graph);
    }
}
