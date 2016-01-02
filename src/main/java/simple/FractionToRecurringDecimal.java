package simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bruce on 2/6/2015.
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        Long numeratorL = new Long(numerator);
        Long denominatorL = new Long(denominator);
        if(numeratorL<0) {
            numeratorL = -1*numeratorL;
        }
        if(denominatorL<0) {
            denominatorL = -1*denominatorL;
        }
        String result = "";
        if(numerator==0){
            return "0";
        }
        if((numerator<0&&denominator>0)||(numerator>0&&denominator<0)) {
            result +="-";
        }
        Long resInt = numeratorL / denominatorL;
        Long remain = numeratorL % denominatorL;
        result += String.valueOf(resInt);
        if (remain == 0) {
            return result;
        } else {
            result += ".";
        }
        List<Integer> remainList = new ArrayList<Integer>();
        Map<Integer, Integer> remainMap = new HashMap<Integer, Integer>();
        int i = 0;
        while (remain != 0) {
            if (!remainMap.containsKey(remain.intValue())) {
                remainList.add((int) (remain * 10 / denominatorL));
                remainMap.put(remain.intValue(), i++);
            } else {
                int start = remainMap.get(remain.intValue());
                for (int j = 0; j < start; j++) {
                    result += String.valueOf(remainList.get(j));
                }
                result += "(";
                for (int j = start; j < i; j++) {
                    result += String.valueOf(remainList.get(j));
                }
                result += ")";
                return result;
            }
            remain = remain * 10 % denominatorL;
        }
        for (int j = 0; j < i; j++) {
            result += String.valueOf(remainList.get(j));
        }
        return result;
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal f = new FractionToRecurringDecimal();
        String res = f.fractionToDecimal(-1, -2147483648);
        System.out.println(res);
        System.out.println(res.equals("0.5"));
        res = f.fractionToDecimal(2, 1);
        System.out.println(res);
        System.out.println(res.equals("2"));
        res = f.fractionToDecimal(2, 3);
        System.out.println(res);
        System.out.println(res.equals("0.(6)"));
    }
}
