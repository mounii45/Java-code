
import java.util.Scanner;

class bubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of elements
        System.out.print("Enter the number of array elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input: Array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Bubble Sort Algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Output: Sorted array
        System.out.println("Sorted elements:");
        for (int num : arr) {
            System.out.println(num);
        }

        sc.close();
    }
}