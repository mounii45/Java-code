package stackCreation;

public class dynamicStack extends customStack {
    public dynamicStack() {
        super();
    }

    public dynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        if (this.isFull()) {
            int[] temp = new int[data.length * 2];// double the size if not sufficent

            // copy the previous items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            // OR sytem.arraycopy func
            data = temp;
        }

        // array is not full after compennsating cond

        return super.push(item);
    }
}
