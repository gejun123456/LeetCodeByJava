package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by bruce on 2/6/2015.
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
        String result = "";
        Integer[] numI = new Integer[num.length];
        for (int i = 0; i < num.length; i++) {
            numI[i] = num[i];
        }
        Arrays.sort(numI, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = String.valueOf(o1);
                String b = String.valueOf(o2);
                int len1 = a.length();
                int len2 = b.length();
                int len = len1 < len2 ? len1 : len2;
                for (int i = 0; i < len; i++) {
                    if (a.charAt(i) > b.charAt(i)) {
                        return 1;
                    } else if (a.charAt(i) < b.charAt(i)) {
                        return -1;
                    }
                }
                if (len1 > len2) {
                    return compare(Integer.valueOf(a.substring(len, len1)), (o2));
                } else if (len2 > len1) {
                    return compare(o1, Integer.valueOf(b.substring(len, len2)));
                } else {
                    return 0;
                }
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        for (int i = 0; i < numI.length; i++) {
            System.out.println(numI[i]+"\n");
            result += String.valueOf(numI[i]);
        }
        int k =0;
        for (int i = 0; i < result.length(); i++) {
            if(result.charAt(i)=='0'&&i!=result.length()-1) {
                k++;
            } else {
                break;
            }
        }
        result = result.substring(k,result.length());
        return result;
    }

    public static void main(String[] args) {
        int[] num = {4704,6306,9385,7536,3462,4798,5422,5529,8070,6241,9094,7846,663,6221,216,6758,8353,3650,3836,8183,3516,5909,6744,1548,5712,2281,3664,7100,6698,7321,4980,8937,3163,5784,3298,9890,1090,7605,1380,1147,1495,3699,9448,5208,9456,3846,3567,6856,2000,3575,7205,2697,5972,7471,1763,1143,1417,6038,2313,6554,9026,8107,9827,7982,9685,3905,8939,1048,282,7423,6327,2970,4453,5460,3399,9533,914,3932,192,3084,6806,273,4283,2060,5682,2,2362,4812,7032,810,2465,6511,213,2362,3021,2745,3636,6265,1518,8398};
        String a = "98909827968595339456944893859149094902689398937839883538183810810780707982784676057536747174237321720571007032685668066758674466986636554651163276306626562416221603859725909578457125682552954605422520849804812479847044453428339323905384638363699366436503636357535673516346233993298316330843021297028227452732697246523622362231322812216213206020001921763154815181495141713801147114310901048";
        String b = "98909827968595339456944893859149094902689398937839883538183810810780707982784676057536747174237321720571007032685668066758674466986636554651163276306626562416221603859725909578457125682552954605422520849804812479847044453428339323905384638363699366436503636357535673516346233993298316330843021297028227452732697246523622362231322812132060221620001921763154815181495141713801147114310901048";
        System.out.println(a);
        System.out.println(new LargestNumber().largestNumber(num)==b);
        System.out.println(a==b);
    }
}
