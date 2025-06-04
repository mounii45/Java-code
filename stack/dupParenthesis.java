package stack;

import java.util.*;

public class dupParenthesis {
    // time complexity : O(n)
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count = 0;
            if (ch != ')') {
                stack.push(ch);
            } else {
                while (!stack.isEmpty() && stack.peek() != '(') {// removing the elements until we find the open bracket
                    count++;
                    stack.pop();
                }
                if (count < 1)
                    return true;// if no operand or operator available b/w brackets
                stack.pop();// to remove closed bracked remained at end

            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "(((a+(b)))+(c+d))";
        if (check(s))
            System.out.println("it is duplicate");
        else
            System.out.println("it is not duplicate parenthesis");
    }
}
