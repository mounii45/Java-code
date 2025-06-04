package stack;

import java.util.*;

public class revString {
   public static void revStr(String str) {
      Stack<Character> s = new Stack<>();
      int idx = 0;
      while (idx < str.length()) {
         s.push(str.charAt(idx));
         idx++;
      }
      StringBuilder sb = new StringBuilder();
      while (!s.isEmpty()) {
         char top = s.pop();
         sb.append(top);
      }

      System.out.println(sb.toString());

   }

   public static void main(String[] args) {
      Stack<Integer> s = new Stack<>();
      s.push(1);
      s.push(2);
      s.push(3);

      revStr("abc");
   }
}
