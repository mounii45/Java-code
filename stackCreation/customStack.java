package stackCreation;

public class customStack {
    protected int[] data; // creating array in the stack obj
    private static final int DEFAULT_SIZE = 10; // if size not mentioned
    int i = -1; // to add elements in stack

    customStack(int size) {
        this.data = new int[size];
    }

    customStack() {
        this(DEFAULT_SIZE);
        // OR this.data = new int[DEFAULT_SIZE];
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("stack is full");
            return false;
        }
        i++;
        data[i] = item;
        return true;
    }

    public boolean isFull() {
        return i == data.length - 1;
    }

    public boolean isEmpty() {
        return i == -1;
    }

    public int pop() throws stackException {
        if (isEmpty()) {
            throw new stackException("stack is empty broo");
        }
        // int temp=data[i];
        // i--;
        // return temp;
        return data[i--];
    }

    public int peek() throws stackException {
        if (isEmpty()) {
            throw new stackException("stack is empty to peek");
        }
        return data[i];
    }

}
