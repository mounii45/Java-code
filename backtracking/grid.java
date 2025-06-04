package backtracking;

public class grid {
    public static int gridWays(int i, int j, int n, int m) {
        if (i == m - 1 && j == n - 1)// target cell
            return 1;
        else if (i == m || j == n)// out of grid
            return 0;
        int w1 = gridWays(i, j + 1, n, m);// right side ways
        int w2 = gridWays(i + 1, j, n, m);// bottom side ways
        return w1 + w2;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        int res = gridWays(0, 0, n, m);
        System.out.println(res);
    }

}
