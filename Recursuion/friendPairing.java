package Recursion;

public class friendPairing {
  public static int friend(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    int ways = friend(n - 1) + ((n - 1) * (friend(n - 2)));
    return ways;
  }

  public static void main(String[] args) {
    int num = friend(4);
    System.out.println(num);
  }
}
