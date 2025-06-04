package BitManipulation;

public class operation {
    public static int getIthBit(int n, int i) {
        return n & (1 << i);
    }

    public static int setIthBit(int n, int i) {
        return n | (1 << i);
    }

    public static int clearIthBit(int n, int i) {
        return n & ~(1 << i);
    }

    public static int updateIthBit(int n, int i, int newBit) {
        /*
         * if (newBit == 0)
         * return clearIthBit(n, i);
         * else
         * return setIthBit(n, i);
         * ( OR )
         */
        n = clearIthBit(n, i);
        int bitMask = newBit << i;// if i=0 no change as indicates clearIthBit & i=1 then indicates for set bit
        return n | bitMask;
    }

    public static int clearLastIBits(int n, int i) {
        return n & (~(0) << i);
    }

    public static int clearBitsInRange(int n, int i, int j) {
        int b = (1 << i) - 1;// (2 power i -1) : b=0001
        int a = ((~0) << (j + 1));// a=1000
        return n & (a | b);
    }

    public static void main(String[] args) {
        System.out.println(getIthBit(10, 1)); // n =1010 & (1<i)=0010 == 0010
        System.out.println(setIthBit(10, 2)); // n =1010 | (1<i)=0100 == 1110 (sets to 1 in 2st pos)
        System.out.println(clearIthBit(10, 1)); // n =1010 & ~(1<i)=1101 == 1000 (sets to 0 in 1st pos)
        // System.out.println(updateIthBit(10, 2, 1)); // updates needs clear & set with
        // newBit (0 or 1 as indication)
        System.out.println(updateIthBit(10, 2, 1)); // updates needs clear & set with newBit (0 or 1 as indication)
        System.out.println(clearLastIBits(15, 2)); // n =1111 & (~(0)<i)=1100 == 1100
        System.out.println(clearBitsInRange(15, 1, 2)); // n =1111 & a|b=1001 ==> 1001 (9)

    }
}
