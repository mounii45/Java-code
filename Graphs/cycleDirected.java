package Graphs;

import java.util.*;

public class cycleDirected {

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

        graph[1].add(new Edge(1, 3, 1));// 0->1 & 1->0 are not created as directed graph only 1 is mentioned

        // 2 vertex

        graph[2].add(new Edge(2, 3, 1));

        // 3 vertex-> no directed edges from 3

        /*
         * 0
         * / \
         * \/ \/
         * 2 1
         * \ /
         * \/ \/
         * 3
         */
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        // functionality in array
        stack[curr] = true;// initially we add
        for (int i = 0; i < graph[curr].size(); i++) {// for total component moves in dfs manner
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) { // cycle (vis again)-> it becomes false
                return true;
            }

            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {// checking for neighbor unvisited & check
                return true;
            }
        }

        stack[curr] = false; // while returning back we remove
        return false;

    }

    public static boolean isCycle(ArrayList<Edge>[] graph) { // O(V+E)

        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {// for unconnectd components
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {// 2 boolean array for visiting
                    return true;
                }
            }

        }

        return false;
    }

    public static boolean[] vis;

    public static void main(String[] args) {

        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];// as it is array
        // null if no values -> empty arraylist

        createGraph(graph);
        System.out.println("cycle is present " + isCycle(graph));
    }
}
