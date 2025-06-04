
public class queueLL {
    static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;

        }

    }

    static class queue {

        static node front = null;
        static node rear = null;

        public static boolean isEmpty() {
            return front == null && rear == null;
        }

        public static void add(int data) {
            node n = new node(data);
            if (front == null) {
                front = rear = n;
                return;
            }
            rear.next = n;
            rear = n;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int data = front.data;

            if (front == rear)
                front = rear = null;
            else
                front = front.next;

            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int d = front.data;
            return d;
        }
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.add(2);
        q.add(3);
        q.add(5);
        q.add(8);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
