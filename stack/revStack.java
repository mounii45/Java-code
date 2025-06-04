package stack;

import java.util.*;

public class revStack {
    public static void pushAtBott(Stack<Integer> s, int data) {
        if (s.isEmpty()) { // push the actual data
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBott(s, data); // remove until empty
        s.push(top); // backtrack the elements in same orders

    }

    public static void rev(Stack<Integer> s) {
        if (s.isEmpty()) { // push the actual data
            return;
        }
        int top = s.pop();
        rev(s); // remove until empty
        pushAtBott(s, top); // backtrack the elements in rev order so at bottom func

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        rev(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }
}
