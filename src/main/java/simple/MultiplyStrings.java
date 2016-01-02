package simple;

/**
 * Created by Administrator on 14-11-3.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String result = new String();
        int[] ans = new int[1001];
        int[] a = new int[num1.length()];
        int[] b = new int[num2.length()];
        for(int i = 0;i<num1.length();i++ ){
           a[i] = num1.charAt(num1.length()-i-1)-48;
        }
        for(int i = 0 ;i<num2.length();i++ ) {
            b[i] = num2.charAt(num2.length()-i-1)-48;
        }
        for(int i = 0 ;i<a.length;i++) {
            int c = 0 ; int k = 0;
            for(int j = 0 ;j<b.length;j++ ) {
                ans[i+j] += a[i]*b[j]+c;
                c = ans[i+j]/10;
                ans[i+j] = ans[i+j]%10;
                k = i+j;
            }
            if(c!=0) {
                ans[k+1] = c;
            }
        }
        int start = 0;
        for(int i = 1000;i>=0;i--) {
            if(ans[i] != 0 ) {
                start = i;
                break;
            }
        }
        for(int i = start;i>=0;i--) {
            result += ans[i];
        }
        return result;
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String result = multiplyStrings.multiply("7204554941577564438","7204554941577564438");
        System.out.println(result);
    }
}
