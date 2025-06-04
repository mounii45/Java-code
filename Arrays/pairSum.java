package Arrays;

public class pairSum {
    public static void main(String[] args) {
        // finding pair sum in array of sorted & rotated
        int[] l = { 11, 15, 6, 8, 9, 10 };
        int target = 16;
        // two pointer approach optimized

        // step 1:find pivot
        int pivot = 0, n = l.length;
        for (int i = 0; i < n - 1; i++) {
            if (l[i] > l[i + 1]) {
                pivot = i;
                break;
            }
        }
        int rp = pivot, lp = pivot + 1;// largest ele is where right pointer lies & smallest is left pointer
        while (lp != rp) {
            if (l[lp] + l[rp] == target) {
                System.out.println(l[lp] + " " + l[rp]);
                break;
            } else if (l[lp] + l[rp] < target)
                lp = (lp + 1) % n;// to rotate circularly back to front
            else
                rp = (n + rp - 1) % n;// from left to right

        }
    }
}
