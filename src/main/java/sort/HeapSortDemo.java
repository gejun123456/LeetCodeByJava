package src.main.java.jiuduooj.sort;

/**
 * Created by bruce on 6/25/2015.
 */
public class HeapSortDemo {
    public static void main(String[] args) {
        int arr[] = { 1,3,2,9,10,5,11,2,877,-1,82};
        heapSort(arr,0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void heapSort(int[] arr, int i, int length) {

    }
}
