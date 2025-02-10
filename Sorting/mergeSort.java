import java.util.Scanner;

public class mergeSort {

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] m = new int[high - low + 1];
        int i = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                m[i++] = arr[left];
                left++;
            } else {
                m[i++] = arr[right];
                right++;
            }
        }

        while (left <= mid) {
            m[i++] = arr[left];
            left++;
        }
        while (right <= high) {
            m[i++] = arr[right];
            right++;
        }

        System.arraycopy(m, 0, arr, low, m.length);
    }

    public static void mergeSort(int[] arr, int low, int high) {

        if (low == high)
            return;// base condition
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void display(int[] arr) {
        System.out.println("The elements after merge sort:");
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
        mergeSort(arr, low, high);
        display(arr);
    }
}
