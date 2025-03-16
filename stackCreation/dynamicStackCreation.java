package stackCreation;

class dynamicStackCreation {
    public static void main(String[] args) throws stackException {
        dynamicStack stack = new dynamicStack(5);

        // OR customStack stack = new dynamicStack(5);
        stack.push(12);
        stack.push(14);
        stack.push(16);
        stack.push(18);

        stack.push(25);
        stack.push(56);
        stack.push(98);

        stack.push(50);
        stack.push(12);

        stack.push(33);
        stack.push(46);
        stack.push(78);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}