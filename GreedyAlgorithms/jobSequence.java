package GreedyAlgorithms;

import java.util.*;

public class jobSequence {
    static class job {
        int id, deadline, profit;

        public job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int info[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 20 } };
        ArrayList<job> j = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            j.add(new job(i, info[i][0], info[i][1]));
        }

        Collections.sort(j, (a, b) -> b.profit - a.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0, profit = 0;
        for (int i = 0; i < j.size(); i++) {
            job curr = j.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                System.out.print("J" + seq.get(i) + " ");
                time++;
            }
        }

        System.out.println();
        System.out.println("total jobs done " + seq.size());

    }
}
