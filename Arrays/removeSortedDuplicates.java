package Arrays;

import java.util.Scanner;

public class removeSortedDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of elements
        System.out.print("Enter the number of array elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input: Array elements
        System.out.println("Enter array elements with sorted duplicates:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0, j;
        for (j = 1; j < n; j++) {
            if (arr[j] != arr[i])
                arr[++i] = arr[j];
        }

        System.out.println("The elements after removing duplicates:");
        for (int k = 0; k < i + 1; k++) {
            System.out.println(arr[k]);
        }

    }
}
