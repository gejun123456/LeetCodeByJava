package simple;

/**
 * Created by bruce on 14-11-12.
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        String sum = "";
        for (int i = 0; i < A.length; i++) {
            sum = add(sum, A[i]);
        }
        int result = covert(sum);
        return result;
    }

    private int covert(String sum) {
        if(sum.length()==32&&sum.charAt(0)=='1') {
            sum = revert(sum);
            return -1*Integer.parseInt(sum,2)-1;
        }
        return Integer.parseInt(sum,2);
    }

    private String revert(String sum) {
        String result = "";
        for(int i = 0;i<sum.length();i++) {
            if(sum.charAt(i) == '0') {
                result +="1";
            } else {
                result += "0";
            }
        }
        return result;
    }

    private String add(String sum, int i) {
        String result = "";
        String bin = Integer.toBinaryString(i);
        int len1 = bin.length();
        int len2 = sum.length();
        int j = 0;
        while (j < len1 && j < len2) {
            char x = sum.charAt(len2-j-1);
            char y = bin.charAt(len1-j-1);
            if (x == '0') {
                if (y == '0') {
                    result ='0'+result;
                } else if (y == '1') {
                    result ='1'+result;
                }
            } else if (x == '1') {
                if (y == '0') {
                    result ='1'+result;
                } else if(y=='1') {
                    result='2'+result;
                }
            } else if(x=='2') {
                if(y=='0') {
                    result='2'+result;
                } else if(y=='1') {
                    result='0'+result;
                }
            }
            j++;
        }
        while(j<len1) {
            result = bin.charAt(len1-j-1)+result;
            j++;
        }
        while(j<len2) {
            result=sum.charAt(len2-j-1)+result;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] A = {43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
        int[] A = {-2147483647,-2147483647,-2147483647,2147483647};
        SingleNumberII si = new SingleNumberII();
        System.out.println(si.singleNumber(A));
    }
}

