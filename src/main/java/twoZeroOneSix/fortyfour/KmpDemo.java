package twoZeroOneSix.fortyfour;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * Created by bruce.ge on 2016/10/26.
 */
public class KmpDemo {
    //return the last index when match get.
    //when no match find return -1.
    public int kmpTwo(String a, String b){
        //first try to get next of b.
        int[]next = new int[b.length()];
        next = getnext(b);
        int i = 0;
        int j =0;
        while(i<a.length()){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
                if(j==b.length()){
                    return i-1;
                }
            } else {
                int u = next[j];
                if(u==-1){
                    i++;
                    j=0;
                }else {
                    j=u;
                }
            }
        }
        return -1;
    }

    //get the next point to check values. this is depend on value to be compared.
    private int[] getnext(String b) {
        int[]next = new int[b.length()];
        next[0]=-1;
        for (int i =1; i < b.length()-1; i++) {
            int a = next[i-1];
            while(a!=-1){
                if(b.charAt(i-1)==b.charAt(a)){
                    next[i]=a+1;
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

    public static void main(String[] args) {
        KmpDemo kemp = new KmpDemo();
        System.out.println(kemp.kmpTwo("hello","llo"));
        assertEquals(4,kemp.kmpTwo("hello","llo"));
        assertEquals(6,kemp.kmpTwo("abdabdefg","abde"));
        assertEquals(-1,kemp.kmpTwo("adfsdfse","adfe"));
        assertEquals(4,kemp.kmpTwo("abfgdegfdged","fgd"));
    }
}
