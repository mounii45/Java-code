package Graphs;

import java.util.ArrayList;

public class articulateTarjan {

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
        graph[0].add(new Edge(0, 1, 1)); // only 1
        graph[0].add(new Edge(0, 3, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 0, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        // 3 vertex
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 0, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 3, 1));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int dt[], int low[], int time, boolean vis[],
            boolean[] ap) { // O(V+E)

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (par == neigh) {
                continue;
            }

            else if (vis[neigh]) { // vis in loop
                low[curr] = Math.min(low[curr], dt[neigh]);// update if vis node found in loop (backend edge)

            }

            else { // (!vis[neigh])

                dfs(graph, neigh, curr, dt, low, time, vis, ap);

                low[curr] = Math.min(low[curr], low[neigh]);// back tracking in case of (1 & 3 ) nodes

                if (par != -1 && dt[curr] <= low[neigh]) {// for internal nodes not for root node (1&3)
                    ap[curr] = true;
                    // System.out.println("AP :" + curr);
                }

                children++;// unvisited node
            }
        }

        // case 1 : disconnected children & root node
        if (par == -1 && children > 1) { // for node 0
            ap[curr] = true;
            // System.out.println("AP :" + curr);
        }
    }

    public static void getAp(ArrayList<Edge>[] graph, int V) { // O(V+E)
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        // to track already printed
        boolean ap[] = new boolean[V];// to avoid printing ap multiple times in large graphs

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                // dfs
                dfs(graph, i, -1, dt, low, time, vis, ap);// initially par:-1
            }
        }

        // print all AP

        for (int i = 0; i < ap.length; i++) {
            if (ap[i]) {
                System.out.println("AP :" + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        getAp(graph, V);
    }
}
