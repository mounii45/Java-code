import java.util.Scanner;

public class quickSort {

    public static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[low];// initial element of part of array

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            // swap the element from left(big) with right(small) by referencing pivot no
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // finally swap the element with its correct position
        int temp1 = arr[low];
        arr[low] = arr[j];
        arr[j] = temp1;
        return j;
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // to find the pivot of the array
            int partition_index = partition(arr, low, high);
            // iteration happens for every part of array where smaller values lies on LHS &
            // vice versa
            quicksort(arr, low, partition_index);
            quicksort(arr, partition_index + 1, high);
        }
    }

    public static void display(int[] arr) {
        System.out.println("The elements after quick sort:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
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

        int low = 0, high = n - 1;
        quicksort(arr, low, high);
        display(arr);
    }
}