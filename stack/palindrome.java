package stack;

import java.util.*;

class node {
    int data;
    node next;

    node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class palindrome {

    public static void main(String[] args) {
        node n1 = new node(1);
        node n2 = new node(2);
        node n3 = new node(2);
        node n4 = new node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        node head = n1;
        node temp = head;

        Stack<Integer> s = new Stack<>();

        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }

        node curr = head;
        int flag = 0;
        while (curr != null) {
            if (curr.data != s.peek()) {
                flag = 1;
            }
            s.pop();
            curr = curr.next;
        }

        if (flag == 0)
            System.out.println("it is palindrome");
        else
            System.out.println("it is not palindrome");

    }
}
