package backtracking;

public class array {
    public static void changeArr(int[] arr, int index, int val) {
        // base case
        if (index == arr.length) {
            printArr(arr);
            return;
        }

        // work
        arr[index] = val;
        changeArr(arr, index + 1, val + 1);
        arr[index] = arr[index] - 2;

    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArr(arr, 0, 1);
        System.out.println("after the backtracking by reducing by 2");
        printArr(arr);
    }
}
