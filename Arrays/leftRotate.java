package Arrays;

import java.util.Scanner;

public class leftRotate {

    public static void reverseArray(int[] arr, int i, int j) {
        int temp;
        while (i <= j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void display(int[] arr) {
        System.out.println("The elements after quick sort:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

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

        System.out.print("No of rotates : ");
        int pos = sc.nextInt();

        int d = pos % n;
        reverseArray(arr, 0, d);
        reverseArray(arr, d + 1, n - 1);
        reverseArray(arr, 0, n - 1);

        display(arr);
    }
}
