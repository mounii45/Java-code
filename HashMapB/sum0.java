import java.util.*;

public class sum0 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int sum = 0, len = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.containsKey(sum))
                len = Math.max(len, i - hm.get(sum));
            else
                hm.put(sum, i);
        }

        System.out.println(len);
    }
}
