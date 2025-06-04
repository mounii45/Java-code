package stack;

import java.util.*;

public class pushAtBottom {
    public static void pushAtBott(Stack<Integer> s, int data) {
        if (s.isEmpty()) { // push the actual data
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBott(s, data); // remove until empty
        s.push(top); // backtrack the elements in same orders

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBott(s, 4);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }
}
