/**
 * Created by Administrator on 14-10-25.
 */
public class ValidNumber {
    public boolean isNumber(String str){
        if(!hasNum(str)){
            return false;
        }
        int j = 0 ;
        int k = 0;

        for(int i =0;i<str.length();i++) {
            if(str.charAt(i) != ' ') {
                j = i;
                break;
            }
        }

        for(int i = str.length()-1; i>=0 ;i--) {
            if(str.charAt(i)!= ' '){
                k=i;
                break;
            }
        }
        if(k<j) {
            return false;
        }
        int count = 0;
        int counte = 0;
        int m  = 0 ;
        str = str.substring(j,k+1);

        if(str.charAt(0)=='-'||str.charAt(0)=='+') {
            str = str.substring(1,str.length());
        }
        if(str.length()==0){
            return false;
        }
//        System.out.println(str);
        int checked = 0;
        for(int i =0;i<=str.length()-1;i++) {
           if((!isNum(str.charAt(i))&&str.charAt(i)!='e'&&str.charAt(i)!='.')||str.charAt(i)==' ') {
               return false;
           }
            if(checked ==1 && !isNum(str.charAt(i))){
                return false;
            }
           if(isNum(str.charAt(i))){
               continue;
           }
           if(str.charAt(i) == '.') {
               if(count == 1){
                   return false;
               }
               if(i==0) {
                   if(str.length() == 0) {
                       return false;
                   }
                   else if(!isNum(str.charAt(i+1))) {
                       return false;
                   }

               }
               else if(i==str.length()-1) {
                   if(!isNum(str.charAt(i-1))) {
                       return false;
                   }
               }
               else if(!isNum(str.charAt(i-1))&&!isNum(str.charAt(i+1))) {
                   return false;
               }
               count++;
           }
           if(str.charAt(i)=='e') {
               checked = 1;
               count --;
               if(counte == 1) {
                   return false;
               }
               if(i==0 || i == str.length()-1) {
                   return false;
               }

               counte++;
               m = i+1;
               break;
           }
       }
        if(m!= 0) {
            if(str.charAt(m)=='+'||str.charAt(m)=='-') {
                m = m +1;
            }
            if(m==str.length())
            {
                return false;
            }
            for(int i =m; i<str.length();i++) {
                if(!isNum(str.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasNum(String str) {
        for(int i = 0; i< str.length();i++) {
            if(isNum(str.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private boolean isNum(char c) {
        if(c>='0'&&c<='9')
            return true;
        return false;
    }

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.isNumber(".1"));
        System.out.println(validNumber.isNumber("G76"));
        System.out.println(validNumber.isNumber("-1."));
        System.out.println(validNumber.isNumber("+.8"));
        System.out.println(validNumber.isNumber("46.e3"));
        System.out.println(validNumber.isNumber(".e3"));
        System.out.println(validNumber.isNumber("6e6.5"));
        System.out.println(validNumber.isNumber( " 005047e+6"));

    }
}
