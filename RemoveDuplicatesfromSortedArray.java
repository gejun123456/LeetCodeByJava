/**
 * Created by Administrator on 14-10-25.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if(A.length==1) {
            return 1;
        }
        else {
            int s =0;
            int i = 0;
            int j = i+1;
            while(j<A.length) {
                if(A[j]==A[i]) {
                    s++;
                    j++;
                }
                else{
                    i=j;
                    j=j+1;
                }
            }
            return A.length -s;
        }
    }
}
