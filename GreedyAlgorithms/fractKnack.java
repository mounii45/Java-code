package GreedyAlgorithms;

import java.util.*;

public class fractKnack {
    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int capacity = 50;
        int ans = 0, n = values.length;
        double[][] ratio = new double[n][2];

        for (int i = 0; i < n; i++) {
            ratio[i][0] = i;
            ratio[i][1] = values[i] / (double) weight[i];
        }

        // as we need descending order to get max no of wt
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0]; // as sorted we the index in that place
            if (weight[idx] <= capacity) {
                capacity = capacity - weight[idx];
                ans += values[idx];
            } else {
                // include fraction
                ans += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println(ans);
    }
}
