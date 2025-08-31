package Graphs;

import java.util.*;

//leetcode : 1971
public class hasPath {
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

    public static boolean dfsPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;

        vis[src] = true;

        // array of lists
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // cecking if neighbor can reach
            if (!vis[e.dest] && dfsPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];// as it is array
        // null if no values -> empty arraylist

        createGraph(graph);
        System.out.println(dfsPath(graph, 0, 5, new boolean[v]));
        // mostly disjoint graphs dont have the path
        System.out.println(dfsPath(graph, 0, 7, new boolean[v]));
    }
}

/*
 * class Solution {
 * 
 * public boolean dfs(ArrayList<Integer>[] graph,int src,int dest,boolean[]
 * vis){
 * if (src==dest)
 * return true;
 * 
 * vis[src]=true;
 * 
 * //array of lists
 * for (int i=0;i<graph[src].size();i++){
 * //cecking if neighbor can reach
 * if (!vis[graph[src].get(i)] && dfs(graph,graph[src].get(i),dest,vis)){
 * return true;
 * }
 * }
 * return false;
 * }
 * 
 */