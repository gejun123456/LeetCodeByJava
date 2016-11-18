package leetcode;

/**
 * Created by bruce on 2/9/2015.
 */
public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        int high = A.length - 1;
        int low = 0;
        int m = search(A, low, high, target);
        int[] result = new int[2];
        if (m == -1) {
            result[0] = -1;
            result[1] = -1;
        } else {
            int start = m, end = m;
            while (start >= low && A[start] == target) {
                start--;
            }
            while (end <= high && A[end] == target) {
                end++;
            }
            result[0] = start+1;
            result[1] = end-1;
        }
        return result;
    }

    private int search(int[] a, int low, int high, int target) {
        if(low>high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (low==high&& a[low] != target) {
            return -1;
        }
        if (a[mid] == target) {
            return mid;
        }
        if (a[mid] > target) {
            return search(a, low, mid-1, target);
        } else {
            return search(a, mid+1, high, target);
        }
    }

    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ints = new SearchForRange().searchRange(A, target);
        for (int s : ints) {
            System.out.println(s);
        }
    }
}
