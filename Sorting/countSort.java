
import java.util.Scanner;

class countSort {
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

        // Count Sort Algorithm
        int maxi = arr[0];
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        int[] count = new int[maxi + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
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