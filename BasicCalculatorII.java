import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by bruce on 6/22/2015.
 */
public class BasicCalculatorII {
    public int calculate(String s) {

        List<Object> midRef = new ArrayList<Object>();
        List<Object> backRef = new ArrayList<Object>();
        midRef = convertStringToMidRef(s);
        backRef = convertMidRefToBackRef(midRef);
        return count(backRef);
    }

    private int count(List<Object> backRef) {
        Stack<Integer> result = new Stack<Integer>();
        for (int i = 0; i < backRef.size(); i++) {
            if (backRef.get(i) instanceof Integer) {
                result.add((Integer) backRef.get(i));
            } else {
                int a = result.pop();
                int b = result.pop();
                Character c = (Character) backRef.get(i);
                int midRes;
                if (c == '+') {
                    midRes = a + b;
                } else if (c == '-') {
                    midRes = b - a;
                } else if (c == '*') {
                    midRes = b * a;
                } else {
                    midRes = b / a;
                }
                result.add(midRes);
            }

        }
        return result.pop();
    }

    private List<Object> convertMidRefToBackRef(List<Object> midRef) {
        List<Object> backRef = new ArrayList<Object>();
        Stack<Character> operator = new Stack<Character>();
        for (int i = 0; i < midRef.size(); i++) {
            if (midRef.get(i) instanceof Integer) {
                backRef.add(midRef.get(i));
                if (operator.size() > 0 && (operator.peek().equals('*') || operator.peek().equals('/'))) {
                    backRef.add(operator.pop());
                }
            } else if (midRef.get(i) instanceof Character) {
                if (midRef.get(i).equals('-') || midRef.get(i).equals('+')) {
                    if (operator.size() > 0) {
                        backRef.add(operator.pop());
                    }
                }
                operator.add((Character) midRef.get(i));
            }
        }
        if (operator.size() != 0) {
            backRef.add(operator.pop());
        }
        return backRef;
    }

    private List<Object> convertStringToMidRef(String s) {
        List<Object> midRef = new ArrayList<Object>();
        int i = 0;
        int len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else {
                if (isdigit(c)) {
                    int a = c - '0';
                    i = i + 1;
                    while (i < len && (isdigit(s.charAt(i)) || s.charAt(i) == ' ')) {
                        if (s.charAt(i) == ' ') {
                            i = i + 1;
                            continue;
                        }
                        a = a * 10 + s.charAt(i) - '0';
                        i = i + 1;
                    }
                    midRef.add(a);
                } else {
                    midRef.add(c);
                    i++;
                }
            }
        }
        return midRef;
    }

    private boolean isdigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;

        }
        return false;
    }

    public static void main(String[] args) {
        BasicCalculatorII basic = new BasicCalculatorII();
        System.out.println(basic.calculate("3+2*2"));
        System.out.println(basic.calculate(" 3/2 "));
        System.out.println(basic.calculate(" 3+5 / 2 "));
        System.out.println(basic.calculate("1 4+7 / 9"));
    }
}
