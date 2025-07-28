package priorityQueuesB;

public class heapSortB {

    // For descending order perform : min Heap logic
    public static void heapify(int arr[], int i, int size) { // O(logn)
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (i == size - 1)
            return;

        // checking if left child is max & it doesnt exceed size
        if (left < size && arr[maxIdx] < arr[left]) {
            maxIdx = left;
        }

        // checking if right child is max(left) & it doesnt exceed size
        if (right < size && arr[maxIdx] < arr[right]) {
            maxIdx = right;
        }

        // if there is a change of maxIdx from initially
        if (maxIdx != i) {
            // swap
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;

            // again verify for the changeed value
            heapify(arr, maxIdx, size);

        }

    }

    public static void heapSort(int[] arr) { // ==> O(2nlogn)
        int n = arr.length;
        // step 1: perform heapify for non leaf nodes to get max heap
        for (int i = (n / 2) - 1; i >= 0; i--) { // O(n/2 * logn) => O(nlogn)
            heapify(arr, i, n);
        }

        // step2 : swap 1st largest with last& call heapify by ignoring last
        for (int i = n - 1; i > 0; i--) { // O(nlogn)

            // swap 1st largest with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, 0, i);// ignoring 1 at last
        }
    }

    public static void main(String[] args) {
        // array must like heap :(max/min)
        int arr[] = { 7, 8, 2, 1 };
        heapSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

    }
}
