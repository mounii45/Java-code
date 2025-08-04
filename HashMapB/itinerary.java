import java.util.*;

public class itinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("chennai", "bengalore"),
                Arrays.asList("mumbai", "delhi"),
                Arrays.asList("goa", "chennai"),
                Arrays.asList("delhi", "goa"));
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> revMap = new HashMap<>();

        for (int i = 0; i < tickets.size(); i++) {
            map.put(tickets.get(i).get(0), tickets.get(i).get(1));
        }
        for (int i = 0; i < tickets.size(); i++) {
            revMap.put(tickets.get(i).get(1), tickets.get(i).get(0));
        }
        String start = "";
        for (String i : map.keySet()) {
            if (!revMap.containsKey(i)) {

                start = i;
                break;
            }
        }

        System.out.print(start);
        while (map.containsKey(start)) {
            start = map.get(start);
            System.out.print(" -> " + start);
        }

    }
}
