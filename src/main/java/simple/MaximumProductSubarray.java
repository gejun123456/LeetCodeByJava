package simple;

/**
 * Created by bruce on 14-11-20.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        int len = A.length;
        if(len==0) {
            return  0;
        }
        int min = A[0];
        int max = A[0];
        int result  =max;
        for (int i = 1; i < len; i++) {
            int p = comparemin(A[i] * min, A[i] * max,A[i]);
            int q  = comparemax(A[i]*min,A[i]*max,A[i]);
            min = p;
            max = q;
            if(max>result) {
                result = max;
            }
        }
        return result;
    }

    private int comparemax(int a, int b, int c) {
        if(b>a) {
            a = b;
        }
        if(c>a) {
            a =c;
        }
        return a;
    }

    private int comparemin(int a, int b,int c) {
        if(b<a) {
            a = b;
        }
        if(c<a) {
            a = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int a[] = {2,3,-2,4};
        MaximumProductSubarray mi = new MaximumProductSubarray();
        int result = mi.maxProduct(a);
        System.out.println(result);
    }

}
