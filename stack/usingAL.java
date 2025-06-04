package stack;

import java.util.ArrayList;

public class usingAL {
    static class Stack {
        static ArrayList<Integer> l = new ArrayList<>();

        public static boolean isEmpty() {
            return l.size() == 0;
        }

        public static void push(int data) {
            l.add(data);
        }

        public static int pop() {
            int top = l.get(l.size() - 1);
            l.remove(l.size() - 1);
            return top;
        }

        public static int peek() {
            return l.get(l.size() - 1);
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
