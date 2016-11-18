package leetcode;

/**
 * Created by bruce on 14-11-12.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int[] c = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                c[k++] = A[i++];
            } else {
                c[k++] = B[j++];
            }
        }
        while (i < m) {
            c[k++] = A[i++];
        }
        while (j < n) {
            c[k++] = B[j++];
        }
        for (i = 0; i < k; i++) {
            A[i] = c[i];
        }
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5, 6, 10};
        int B[] = {2, 3, 4, 5, 6};
    }
}
