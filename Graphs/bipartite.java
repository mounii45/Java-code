package Graphs;

import java.util.*;

public class bipartite {

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
        graph[0].add(new Edge(0, 2, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;// no color initially
        }

        Queue<Integer> q = new LinkedList<>();
        // outer loop for disconnected components
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {// for all components check
                q.add(i);
                col[i] = 0;// yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);// e.dest i.e connected
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;// opp color for neigh
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[curr] == col[e.dest]) {
                            return false;
                        }
                    }
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        // bipartite : think of 2 sets with 2 colors
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];// as it is array
        // null if no values -> empty arraylist

        createGraph(graph);
        System.out.println(isBipartite(graph));

    }
}
