import java.util.*;

public class HashSet1 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(1);
        System.out.println(hs);

        if (hs.contains(2))
            System.out.println("2 present");

        hs.remove(1);
        hs.add(1);
        System.out.println(hs);

        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        TreeSet<Integer> ts = new TreeSet<>();
        // O(logn)
        ts.add(9);
        ts.add(2);
        ts.add(1);
        System.out.println(ts);

    }
}
