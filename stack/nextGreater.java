package stack;

import java.util.*;

public class nextGreater {
    public static void nextBig(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] nextBig = new int[arr.length];
        nextBig[arr.length - 1] = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty())
                nextBig[i] = -1;
            else
                nextBig[i] = s.peek();
            s.push(arr[i]);
        }

        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.println(nextBig[i]);
        }

    }

    public static void main(String[] args) {
        // int[] arr = { 6, 8, 0, 1, 3 }; ---> 8,-1,1,3,-1
        int[] arr = { 5, 8, 0, 2, 10 }; // --->8,10,2,10,-1

        nextBig(arr);

    }
}
