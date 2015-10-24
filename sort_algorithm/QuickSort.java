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
        int arr[] = {1,0,1,0,2,4,3,12,423,122,321,-432,321};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }
}
