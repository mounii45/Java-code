package Graphs;

public class disjointUnion {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {// provides top root at position of parent
        if (par[x] == x)
            return x;

        // stores to reduce T.C instead of returing to topmost node everytime
        return par[x] = find(par[x]);// optimization
    }

    public static void union(int a, int b) {

        int parA = find(a), parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;// leaders leader
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;// no updation of rank
        } else {
            par[parB] = parA;
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println("inital parent of 3 :" + find(3));
        union(1, 3);
        System.out.println("parent of 3 :" + find(3));
        union(2, 4);
        System.out.println("parent of 4 :" + find(4));
        union(3, 6);
        System.out.println("parent of 6 :" + find(6));
        union(1, 4);
        System.out.println("parent of 4 :" + find(4));
        union(1, 5);
    }
}
