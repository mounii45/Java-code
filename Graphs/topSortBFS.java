package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class topSortBFS {
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

        // 2 vertex

        graph[2].add(new Edge(2, 3, 1));

        // 3 vertex-> no directed edges from 3
        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    public static void calIndeg(ArrayList<Edge>[] graph, int indeg[]) {
        for (int i = 0; i < graph.length; i++) {

            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) { // O(V+E) : using BFS explicit queue

        // no need of vis boolean array here

        int indeg[] = new int[graph.length];

        calIndeg(graph, indeg);// calculating indegree to all nodes

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {// for knowing the starting source i.e 0 indegree
            if (indeg[i] == 0) {
                q.add(i); // 4 & 5 will be added in queue
            }
        }

        while (!q.isEmpty()) {// bfs manner
            int curr = q.remove();
            System.out.print(curr + " ");// toplogical sort

            // bfs
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                indeg[e.dest]--;// while we visit the neigh decresae their indegre

                if (indeg[e.dest] == 0) {// when the indeg becomes 0 then add to queue
                    q.add(e.dest);
                }
            }

        }

    }

    public static void main(String[] args) {

        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];// as it is array
        // null if no values -> empty arraylist

        createGraph(graph);
        topSort(graph);
    }
}
