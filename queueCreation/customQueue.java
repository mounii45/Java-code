
public class customQueue {
    protected int[] data; // creating array in the queue obj
    private static final int DEFAULT_SIZE = 10; // if size not mentioned

    // generally we use 2 ptrs but here with 1 ptr we solve

    int end = -1; // to add elements in stack

    customQueue(int size) {
        this.data = new int[size];
    }

    customQueue() {
        this(DEFAULT_SIZE);
        // OR this.data = new int[DEFAULT_SIZE];
    }

    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("queue is full");
            return false;
        }
        end++;
        data[end] = item;
        return true;
    }

    // to remove : as we have only 1 ptr ->we need to move from last to 1st to
    // remove the first element : O(N)

    public boolean isFull() {
        return end == data.length - 1;
    }

    public boolean isEmpty() {
        return end == -1;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        int removed = data[0];

        // shift ele to left by 1 pos
        for (int i = 0; i < end; i++) {
            data[i] = data[i + 1];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty to peek");
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i <= end; i++) {
            System.out.println(data[i] + " ");
        }
    }

}
