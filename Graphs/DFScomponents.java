package Graphs;

import java.util.*;

import stackCreation.stackException;

//leetcode :200
public class DFScomponents {

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

        // 2nd component

        // 7 vertex
        graph[7].add(new Edge(7, 8, 1));

        // 8 vertex
        graph[8].add(new Edge(8, 7, 1));

        // 3rd component

        // 9vertex
        graph[9].add(new Edge(9, 9, 1));

    }

    public static void dfs(ArrayList<Edge>[] graph, int curr) { // O(V+E)

        System.out.println(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {// size of neighbors it has connected
            Edge e = graph[curr].get(i);
            if (!vis[e.dest])// check for the neighbor if it is visited not for curr
                dfs(graph, e.dest);
        }
    }

    public static boolean[] vis;

    public static void main(String[] args) {

        int v = 10;
        ArrayList<Edge>[] graph = new ArrayList[v];// as it is array
        // null if no values -> empty arraylist

        vis = new boolean[v];
        createGraph(graph);

        System.out.println("if unconnected components are ignored");
        dfs(graph, 0);

        System.out.println("if unconnected components are considered with modification");

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfs(graph, i);
            }

        }

    }
}
