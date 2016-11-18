package code_2016.leetcode_44;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bruce.ge on 2016/10/26.
 */
public class KmpWithQuestionMark {
    public int kmpWithMark(String a,String b){
        //shall go to match with questionMark.
        int[] next = new int[b.length()];
        next=  getNext(b);
        int i=0;
        int j =0;
        while(i<a.length()){
            if(same(a.charAt(i),b.charAt(j))){
                i++;
                j++;
                if(j==b.length()){
                    return i-1;
                }
            } else {
                int u = next[j];
                if(u==-1){
                    i=i+1;
                    j=0;
                } else {
                    j = u;
                }
            }
        }
        return -1;
    }

    private int[] getNext(String b) {
        int[] next = new int[b.length()];
        next[0]=-1;
        for (int i = 1; i < b.length(); i++) {
            int a = next[i-1];
            while(a!=-1){
                if(same(b.charAt(i-1),b.charAt(a))){
                    next[i]= a+1;
                    break;
                }
                a = next[a];
            }
            if(a==-1){
                next[i]=0;
            }
        }
        return next;
    }

    private boolean same(char c, char c1) {
        if(c=='?'||c1=='?'||c==c1){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        KmpWithQuestionMark kmp = new KmpWithQuestionMark();
        assertThat(kmp.kmpWithMark("hello","?h")).isEqualTo(-1);
        assertThat(kmp.kmpWithMark("hello","?ell")).isEqualTo(3);
        assertThat(kmp.kmpWithMark("hiyouguys","??")).isEqualTo(1);
        assertThat(kmp.kmpWithMark("okyouare","ok??")).isEqualTo(3);
        assertThat(kmp.kmpWithMark("yes","ye??")).isEqualTo(-1);
        assertThat(kmp.kmpWithMark("abcdef","a?de")).isEqualTo(-1);
        //so this is not right. inned to handle it.
        //can only use with substring.
        System.out.println(kmp.kmpWithMark("abcdef","a?de"));
    }
}
