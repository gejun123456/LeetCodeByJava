package simple;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bruce on 14-11-19.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        int max = -1;
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if(A[i]>max){
                max= A[i];
            }
        }
        if(max<1){
            return 1;
        }

        for (int i = 1; i <= max+1 ; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 0};
        FirstMissingPositive fi = new FirstMissingPositive();
        int result = fi.firstMissingPositive(a);
        System.out.println(result);
    }
}
