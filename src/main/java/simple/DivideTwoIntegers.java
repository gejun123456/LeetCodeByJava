package simple;

/**
 * Created by Administrator on 14-11-2.
 */
public class DivideTwoIntegers {
    private final static int max = 2147483647;
    private final static int min = -2147483648;
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend > 0 && divisor > 0) {
            int result = 0;
            int p = divisor;
            if (dividend < divisor) {
                return 0;
            }
            result = 1;
            int k = 0;
//            divisor = divisor<<1;
            while (divisor < dividend) {
                if((divisor<<1)>=0) {
                 divisor <<= 1;
                 result<<=1;
                }
                else {
                    k = 1;
                    break;
                }
            }
            if (divisor == dividend) {
                return result;
            } else {
                if(k==0) {
                return (result >> 1) + divide(dividend - (divisor >> 1), p);
                }
                else
                    return result + divide(dividend-divisor,p);
            }
        }
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            if(divisor==min) {
                return 0;
            }
            if(dividend == min) {
                return -1*divide(dividend,-1*divisor);
            }
            return -1 * divide(-1 * dividend, divisor);
        }
        if (dividend < 0 && divisor < 0) {
            if(dividend==min && divisor==min) {
                return 1;
            }
            else if(divisor == min) {
                return 0;
            }
            else if(dividend == min) {
                int p = divisor;
                int result = 1;
                int k = 0 ;
                while(divisor>dividend) {
                    if((divisor<<1)<=0) {
                        divisor<<=1;
                        result <<=1;
                    } else {
                        k=1;
                        break;
                    }
                }
                if(divisor == dividend) {
                    return result;
                }
                else {
                    if(k==0) {
                        return (result >> 1) + divide(dividend - (divisor >> 1), p);
                    }
                    else
                        return result + divide(dividend-divisor,p);
                }

            }

            return divide(-1 * dividend, -1 * divisor);
        }
        return 0;
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
//        System.out.println(divideTwoIntegers.divide(100,2));
        System.out.println(divideTwoIntegers.divide(-2147483648,1));
        System.out.println(divideTwoIntegers.divide(2147483647,2));
    }
}
