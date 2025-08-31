package Graphs;

import java.util.ArrayList;
import java.util.Stack;

//we use topological sort & DFS
public class kosaraju {
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
        graph[0].add(new Edge(0, 2, 1)); // only 1
        graph[0].add(new Edge(0, 3, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));

        // 3 vertex
        graph[3].add(new Edge(3, 4, 1));
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> stack) {
        vis[curr] = true;
        // functionality in array

        for (int i = 0; i < graph[curr].size(); i++) {// for total component moves in dfs manner
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {// checking for neighbor unvisited & check
                topSortUtil(graph, e.dest, vis, stack);
            }
        }

        stack.push(curr); // at last we add to stack when we pop out it comes 1st (dependency graph)

    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) { // O(V+E)
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {// size of neighbors it has connected
            Edge e = graph[curr].get(i);
            if (!vis[e.dest])// check for the neighbor if it is visited not for curr
                dfs(graph, e.dest, vis);
        }
    }

    public static void kosarajuAlgorithm(ArrayList<Edge>[] graph, int v) {// O(V+E)
        // step 1: topological sort --> place elements in stack

        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        // step 2 :transpose of graph (exchange src & dest direction of edge)
        ArrayList<Edge>[] transpose = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;// re initialize all values to use again
            transpose[i] = new ArrayList<>();// inner list initialization

        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); i++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src, e.wt));// reverse edge
            }
        }

        // step 3: use stack order to perform dfs on transpose graph

        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SSC-->");
                dfs(transpose, curr, vis);// on transpose graph
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];// as it is array
        // null if no values -> empty arraylist

        createGraph(graph);
        kosarajuAlgorithm(graph, v);

    }
}
