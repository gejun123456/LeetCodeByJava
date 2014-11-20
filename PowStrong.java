/**
 * Created by bruce on 14-11-20.
 */
public class PowStrong {
    public double pow(double x, int n) {
        if(n==0) {
            return 1;
        }
        if (n > 0) {
            return powWithArr(x, n);
        } else {

            if(n==-2147483648){
                return 1/(powWithArr(x,2147483647)*x);
            }
            return 1 / powWithArr(x, -1 * n);
        }
    }

    private double powWithArr(double x, int n) {
        if (n == 1) {
            return x;
        } else {
            int m = n / 2;
            double s = powWithArr(x,n/2);
            if (2 * m == n) {
                return s*s;
            } else {
                return s*s * x;
            }
        }
    }

    public static void main(String[] args) {
        PowStrong ow = new PowStrong();
        double res = ow.pow(2, 3);
        System.out.println(res);
    }
}
