package stack;

import java.util.*;

public class twoQueues {
    static class stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {// just add the elements in order in non empty queue
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int top = -1;
            // case 1 : emprtying q1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty())// loosing the top data when reached without being added to other queue
                        break;
                    q2.add(top);
                }

            }
            // case 2: emptying q2
            else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty())
                        break;
                    q1.add(top);
                }

            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int top = -1;
            // case 1 : emprtying q1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);// adding every ele to other in same order without losing
                }

            }
            // case 2: emptying q2
            else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }

            }
            return top;

        }

    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);

        s.pop();
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
