package Graphs;

import java.util.ArrayList;

public class bellmanFord {

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
        graph[1].add(new Edge(1, 2, -4));

        // 2 vertex
        graph[2].add(new Edge(2, 3, 2));

        // 3 vertex
        graph[3].add(new Edge(3, 4, 4));

        // 4 vertex
        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellman(ArrayList<Edge>[] graph, int src) { // more T.C but for -ve edges its sol
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        // bellman --> until v-1
        for (int i = 0; i < V - 1; i++) {
            // edges : O(E)
            // move to each vertices by vis all edges
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // relaxation step
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        bellman(graph, 0);
    }
}
