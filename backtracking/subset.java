package backtracking;

public class subset {
    public static void sub(String str, int i, String ans) {
        // base case
        if (i == str.length()) { // last level in rec track

            if (ans.length() == 0) {// empty subset
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // work
        sub(str, i + 1, ans + str.charAt(i));// yes condition to be part of subset
        sub(str, i + 1, ans);// no condition
    }

    public static void main(String[] args) {

        sub("abc", 0, "");
    }
}
