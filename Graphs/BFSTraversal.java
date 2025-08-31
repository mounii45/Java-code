package Graphs;

import java.util.*;

import stackCreation.stackException;

public class BFSTraversal {

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
        graph[3].add(new Edge(3, 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];// maintains the graph of visiting info to visit only once
        q.add(0);// indicating starting point is zero

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {// didnt visit
                System.out.println(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {// size of neighbors it has connected
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);// adding all nodes it connected to
                }
            }
        }
    }

    public static void main(String[] args) {

        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];// as it is array
        // null if no values -> empty arraylist

        createGraph(graph);
        bfs(graph);

    }
}
