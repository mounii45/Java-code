
import java.util.*;

public class LinkedHM {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("india", 12);

        lhm.put("korea", 18);
        lhm.put("europe", 17);
        lhm.put("china", 105);

        System.out.println(lhm);

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("india", 12);

        tm.put("korea", 18);
        tm.put("europe", 17);
        tm.put("china", 15);

        System.out.println(tm);
    }
}
