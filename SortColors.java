import java.util.HashMap;

/**
 * Created by bruce on 14-11-12.
 */
public class SortColors {
    public void sortColors(int[] A) {
        int len = A.length;
        int na = -1;
        int nb = -1;
        for (int i = 0; i < len; i++) {
            if(A[i]==0) {
                if(na!=-1) {
                    for(int j =i;j>na;j--) {
                        A[j] =A[j-1];
                    }
                    A[na] = 0;
                    na++;
                    if(nb!=-1) {
                        nb++;
                    }
                }else if(nb!=-1) {
                    for(int j = i;j>nb;j--) {
                        A[j] = A[j-1];
                    }
                    A[nb] = 0;
                    nb++;
                }
            }
            else if(A[i] == 1) {
                if(na ==-1&&nb!=-1) {
                    na =nb;
                }
                if(na == -1&&nb==-1) {
                    na = i;
                }
                if(nb!=-1) {
                    for(int j = i;j>nb;j--) {
                        A[j] = A[j-1];
                    }
                    A[nb] = 1;
                    nb++;
                }
            } else {
                if(nb == -1) {
                    nb = i;
                }
            }
        }
    }


    public static void main(String[] args) {
        int A[] = {1,2,2,2,2,0,0,0,1,1};
        SortColors so = new SortColors();
        so.sortColors(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
