
import java.util.HashMap;
import java.util.Set;

public class intro {
    public static void main(String[] args) {
        // create
        HashMap<String, Integer> hm = new HashMap<>();

        // put : O(1)
        hm.put("bajji", 10);
        hm.put("samosa", 20);
        hm.put("pani puri", 30);
        hm.put("vada", 25);

        System.out.println(hm);

        // get :O(1)
        System.out.println("price of vada " + hm.get("vada"));

        // remove:O(1)
        System.out.println("removing samosa return value " + hm.remove("samosa"));
        System.out.println("removing samosa return value " + hm.remove("samosa"));

        // search :O(1)
        if (!hm.containsKey("samosa"))
            System.out.println("samosa out of stock");

        // Iterate

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println(k + ":" + hm.get(k));
        }

    }
}
