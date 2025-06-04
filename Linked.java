package linkedlist;

import java.util.Scanner;

class node {
    private int data, length;
    private node next;

    node(int data) {
        this.data = data;
        this.next = null;
    }

    public void setdata(int data) {
        this.data = data;
    }

    public int getdata() {
        return data;
    }

    public node getnext() {
        return next;
    }

    public void setnext(node next) {
        this.next = next;
    }

}

public class Linked {
    private node head = null;
    private node last = null;

    public void insert(node newnode) {
        node temp = head;
        if (head == null) {
            head = last = newnode;
        } else {
            last.setnext(newnode);
            last = newnode;
        }
    }

    public void insertAtBeg(node newNode) {

        newNode.setnext(head);
        head = newNode;
    }

    public void insertAtMid(int num, int pos) {
        node newNode = new node(num);

        int i = 1;
        node temp = head;
        while (i++ < pos - 1) {
            temp = temp.getnext();
        }
        node curr = temp.getnext();
        temp.setnext(newNode);
        newNode.setnext(curr);
    }

    public void delete(int pos) {
        if (pos == 1) {
            node temp = head;
            head = head.getnext();
            temp.setnext(null);// for garbage collector
        } else {
            node prev = head, curr = head.getnext();
            int i = 2;// should start from next of head
            while (i < pos && curr != null) {

                prev = curr;
                curr = curr.getnext();
                i++;
            }
            if (curr != null) {
                prev.setnext(curr.getnext());
                curr.setnext(null); // Optional: helps the garbage collector
            } else {
                System.out.println("Position out of bounds.");
            }
        }
    }

    public void length() {
        node temp = head;
        int i = 0;
        while (temp != null) {
            i++;
            temp = temp.getnext();
        }
        System.out.println("length of linked list is " + i);
    }

    public void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.getdata() + "-->");
            temp = temp.getnext();
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linked list = new Linked();
        node first = new node(10);
        node sec = new node(20);
        node third = new node(30);
        node four = new node(40);
        System.out.println("Inserting at last usually");
        list.insert(first);
        list.insert(sec);
        list.insert(third);

        list.display();
        System.out.println("inserting 40 at begining");
        list.insertAtBeg(four);
        list.display();

        System.out.println("enter the pos u want to insert");
        int pos = sc.nextInt();
        System.out.println("enter the data u want to insert");
        int num = sc.nextInt();
        list.insertAtMid(num, pos);
        System.out.println("inserting data at middle");
        list.display();

        System.out.println("enter the pos u want to delete");
        int delpos = sc.nextInt();

        list.delete(delpos);
        System.out.println("after deleting 10");
        list.display();

        list.length();
    }
}
