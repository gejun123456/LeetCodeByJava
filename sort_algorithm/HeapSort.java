package sort_algorithm;

/**
 * Created by bruce on 14-12-16.
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 6, 7, 0, 1, 2, 3, 6, 3, 2, 1, 2, 34, 6, 8, 21, 34, 21, 5, 23, 12};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }

    private static void heapSort(int[] arr) {
        int a[] = new int[arr.length];
        init(a,arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[0];
            a[0] = a[arr.length-i-1];
            makeStillHeap(a,0,arr.length-i-1);
        }
    }

    private static void makeStillHeap(int[] a, int i ,int len) {
        int left = i*2+1;
        int right = i*2+2;
        if(left>len) {
            return;
        }
        if(right>len) {
            if(a[left]<a[i]) {
                covert(a,i,left);
            }
        } else {
            left = a[left]<a[right]?left:right;
            if(a[left]<a[i]) {
                covert(a,i,left);
                makeStillHeap(a,left,len);
            }
        }

    }

    private static void init(int[] a, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
            makeAheap(a,i);
        }
    }

    private static void makeAheap(int[] a, int i) {
        if(i==0){
            return;
        }
        if(i%2==1){
            int root = i/2;
            int right = i+1;
            if(a[i]>=a[root]) {
                return;
            }
            if(a[i]<a[root]){
                covert(a,i,root);
                makeAheap(a,root);
            }
        } else {
            int root = i/2-1;
            if(a[i]>=a[root]) {
                return;
            }
            if(a[i]<a[root]) {
                covert(a,i,root);
                makeAheap(a,root);
            }
        }
    }

    private static void covert(int[] a, int i, int root) {
        int s = a[i];
        a[i] = a[root];
        a[root] = s;
    }
}
