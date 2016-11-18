package leetcode;

/**
 * Created by bruce on 2/6/2015.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int len1 = a.length;
        int len2 = b.length;
        int len = len1<len2?len1:len2;
        for (int i = 0; i <len; i++) {
            int res = Integer.valueOf(a[i]).compareTo(Integer.valueOf(b[i]));
            if(res>0) {
                return 1;
            } else if(res<0) {
                return -1;
            }
        }
        if(len1==len2) {
            return 0;
        } else if(len1>len2) {
            for (int i = len; i < len1 ; i++) {
                if(Integer.valueOf(a[i])>0) {
                    return 1;
                }
            }
            return 0;
        } else {
            for (int i = len; i < len2 ; i++) {
                if(Integer.valueOf(b[i])>0) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        String a = "01";
        String b = "1";
        String c = "1.2";
        String d = "13.37";
        CompareVersionNumbers com = new CompareVersionNumbers();
        System.out.println(com.compareVersion(a,b));
        System.out.println(com.compareVersion(b,c));
        System.out.println(com.compareVersion(c,d));
//        System.out.println(com.compareVersion(a,b));
    }
}
