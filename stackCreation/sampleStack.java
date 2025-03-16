package stackCreation;

public class sampleStack {
    public static void main(String[] args) throws stackException {
        customStack stack = new customStack(5);
        stack.push(12);
        stack.push(14);
        stack.push(16);
        stack.push(18);

        stack.push(25);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
