package leetcode;

/**
 * Created by bruce on 14-12-8.
 */
public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int left[] = new int[len];
        int right[] = new int[len];
        left[0]=0;
        int min=0;
        for (int i = 1; i < len; i++) {
            if(ratings[i]>ratings[i-1]) {
                min++;
            } else {
                min = 0;
            }
            left[i] = min;
        }
        right[len-1]=0;
        min = 0;
        for (int i = len-2; i >=0 ; i--) {
            if(ratings[i]>ratings[i+1]) {
                min++;
            } else {
                min=0;
            }
            right[i] = min;
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            int max = left[i]>right[i]?left[i]:right[i];
            result +=(max+1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] rating = {2,1,3};
        int result = new Candy().candy(rating);
        System.out.println(result);
    }
}
