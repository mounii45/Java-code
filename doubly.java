package linkedlist;

import java.util.Scanner;

class dnode {
    private int data, length;
    private dnode next, prev;

    dnode(int data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }

    public void setdata(int data) {
        this.data = data;
    }

    public int getdata() {
        return data;
    }

    public dnode getnext() {
        return next;
    }

    public void setnext(dnode next) {
        this.next = next;
    }

    public dnode getprev() {
        return prev;
    }

    public void setprev(dnode prev) {
        this.prev = prev;
    }

}

public class doubly {
    private dnode head = null, last = null, previous;

    public void insert(int data) {
        dnode newnNode = new dnode(data);
        if (head == null) {
            head = last = newnNode;
        } else {

            last.setnext(newnNode);
            newnNode.setprev(last);
            last = newnNode;
        }
    }

    public void length() {
        dnode temp = head;
        int i = 0;
        while (temp != null) {
            i++;
            temp = temp.getnext();
        }
        System.out.println("length of linked list is " + i);
    }

    public void display() {
        dnode temp = head;
        while (temp != null) {
            System.out.print(temp.getdata() + "<-->");
            temp = temp.getnext();
        }
        System.out.print("NULL");
        System.out.println();
    }

    public void reverse() {
        dnode temp = head;
        while (temp.getnext() != null) {

            temp = temp.getnext();
        }

        dnode curr = temp;
        while (curr != null) {
            System.out.print(curr.getdata() + "<-->");
            curr = curr.getprev();
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void main(String[] args) {
        doubly list = new doubly();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.display();
        list.reverse();
    }
}
