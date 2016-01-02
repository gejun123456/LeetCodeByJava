package simple;

import java.util.Stack;

/**
 * Created by bruce on 14-11-20.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<String> st = new Stack<String>();
        for (int i = 0; i < len; i++) {
            char c = tokens[i].charAt(0);
            if(c>='0'&&c<='9'||tokens[i].length()>1) {
                st.push(tokens[i]);
            }
            else if(c=='+'||c=='-'||c=='*'||c=='/') {
                Integer b= Integer.parseInt(st.pop());
                Integer a =Integer.parseInt(st.pop());
                String res = "";
                if(c=='+') {
                     res = String.valueOf(a+b);
                }
                if(c=='-') {
                     res = String.valueOf(a-b);
                }
                if(c=='*') {
                     res = String.valueOf(a*b);
                }
                if(c=='/') {
                     res = String.valueOf(a/b);
                }
                st.push(res);
            }
        }
        return Integer.parseInt(st.pop());
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation ev = new EvaluateReversePolishNotation();
        String[] a = {"3","-4","+"};
        int result = ev.evalRPN(a);
        System.out.println(result);
    }
}
