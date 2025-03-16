public class circularQueue {
    protected int[] data; // creating array in the queue obj
    private static final int DEFAULT_SIZE = 10; // if size not mentioned

    // generally we use 2 ptrs but here with 1 ptr we solve

    int end = 0; // to add elements in stack
    int front = 0;
    private int size = 0;

    circularQueue(int size) {
        this.data = new int[size];
    }

    circularQueue() {
        this(DEFAULT_SIZE);
        // OR this.data = new int[DEFAULT_SIZE];
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }

        data[end] = item;
        end = (end + 1) % data.length;
        size++;
        return true;
    }

    // to remove : as we have only 1 ptr ->we need to move from last to 1st to
    // remove the first element : O(N)

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        int removed = data[front];

        // we dont shift ele in circular queue
        front = (front + 1) % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty to peek");
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }
        int i = front;
        do {
            System.out.print(data[i] + "->");
            i++;
            i %= data.length;

        } while (i != end);
        System.out.println("end");
    }
}
