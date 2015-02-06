/**
 * Created by bruce on 14-11-22.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        int[] B = new int[A.length];
        int flag = 0;
        int k = 0;
        if(A.length==0) {
            return 0;
        }
        B[k++] = A[0];
        for (int i = 1; i < A.length; i++) {
            if(A[i]==A[i-1]) {
                flag++;
                if(flag<2) {
                    B[k++] = A[i];
                }
            } else {
                flag = 0;
                B[k++] = A[i];
            }
        }
        for (int i = 0; i < k; i++) {
            A[i] = B[i];
        }
        return k;
    }
}
