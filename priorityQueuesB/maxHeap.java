package priorityQueuesB;

import java.util.ArrayList;

import stack.pushAtBottom;

//MAX HEAP

public class maxHeap {
    static ArrayList<Integer> l = new ArrayList<>();

    static class heap1 {

        public static void insert(int data) { // O(logn)
            // insert at last index
            l.add(data);

            int x = l.size() - 1;// x is child of par
            // parent idx
            int par = (x - 1) / 2;

            // considering MAX HEAP
            while (x > 0 && l.get(x) > l.get(par)) { // level order -> O(logn)
                // swaps the parent & child ele
                int temp = l.get(par);
                l.set(par, l.get(x));
                l.set(x, temp);

                x = par;
                par = (x - 1) / 2;
            }

        }

        public int peek() {
            return l.get(0);
        }

        private void heapify(int par) {
            int left = 2 * par + 1;
            int right = 2 * par + 2;
            int maxIdx = par;

            if (par == l.size())
                return;

            // checking if left child is max & it doesnt exceed size
            if (left < l.size() && l.get(maxIdx) < l.get(left)) {
                maxIdx = left;
            }

            // checking if right child is max(left) & it doesnt exceed size
            if (right < l.size() && l.get(maxIdx) < l.get(right)) {
                maxIdx = right;
            }

            // if there is a change of maxIdx from initially
            if (maxIdx != par) {
                // swap
                int temp = l.get(maxIdx);
                l.set(maxIdx, l.get(par));
                l.set(par, temp);

                // again verify for the changeed value
                heapify(maxIdx);

            }

        }

        public int remove() {
            int data = l.get(0);

            // step 1: swap the first & last idx
            int lastIdx = l.size() - 1;
            int temp = l.get(0);
            l.set(0, l.get(lastIdx));
            l.set(lastIdx, temp);

            // step 2: remove last idx
            l.remove(l.size() - 1);

            // step 3 : heapify
            heapify(0);

            return data;
        }
    }

    public static void main(String[] args) {
        heap1 h = new heap1();
        h.insert(2);
        h.insert(3);
        h.insert(5);
        h.insert(1);

        h.remove();

        System.out.println("max HEAP");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }

        System.out.println("maximum value is " + h.peek());

    }
}
