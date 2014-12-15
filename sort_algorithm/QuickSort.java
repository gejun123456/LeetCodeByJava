package sort_algorithm;

/**
 * Created by bruce on 14-12-15.
 */
public class QuickSort {
    private static void quickSort(int arr[]) {
        int len = arr.length;
        quickSortFunc(arr, 0, len - 1);
    }

    private static void quickSortFunc(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int x = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && arr[j] > x) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] < x) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = x;
        quickSortFunc(arr, low, i - 1);
        quickSortFunc(arr, i + 1, high);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 6, 7, 0, 1, 2, 3, 6, 3, 2, 1, 2, 34, 6, 8, 21, 34, 21, 5, 23, 12};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }
}
