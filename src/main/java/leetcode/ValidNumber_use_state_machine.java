package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bruce.ge on 2016/10/26.
 */
/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

Subscribe to see which companies asked this question*/
/*
*  try to create a state control to get over the task.
*   there will be state and control and end to get the work down.
*
 *
*
*
*
*
* */

public class ValidNumber_use_state_machine {
    public boolean isNumber(String s) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                start++;
            } else {
                break;
            }
        }

        int end = s.length();
        for (int i = s.length()-1; i >=start; i--) {
            if(s.charAt(i)==' '){
                end--;
            } else{
                break;
            }
        }
        s = s.substring(start,end);
        if(s.length()==0){
            return false;
        }
        int len = s.length();
        int k = 0;
        int state = 0;
        while(k<len){
            char c = s.charAt(k);
            if(c==' '){
                return false;
            }
            k++;
            switch (state){
                case 0 :
                    if(c=='+'||c=='-'){
                        state=2;
                    } else if(isdigit(c)){
                        state=1;
                    } else if(c=='.'){
                        state=7;
                    } else{
                        state=100;
                    }
                    break;
                case 1:
                    if(isdigit(c)){
                        state=1;
                    } else if(c=='.'){
                        state=3;
                    } else if(c=='e'){
                        state=5;
                    } else {
                        state=100;
                    }
                    break;
                case 2:
                    if(isdigit(c)){
                        state=1;
                    } else if(c=='.'){
                        state=7;
                    }
                    else {
                        state=100;
                    }
                    break;
                case 3:
                    if(isdigit(c)){
                        state=4;
                     } else if(c=='e'){
                        state=5;
                    } else {
                        state=100;
                    }
                    break;
                case 4:
                    if(isdigit(c)){
                        state=4;
                    } else if(c=='e'){
                        state=5;
                    } else {
                        state=100;
                    }
                    break;
                case 5:
                    if(isdigit(c)){
                        state=6;
                    } else if(c=='+'||c=='-'){
                        state=8;
                    }
                    else {
                        state=100;
                    }
                    break;
                case 6:
                    if(isdigit(c)){
                        state=6;
                    } else {
                        state=100;
                    }
                    break;
                case 7:
                    if(isdigit(c)){
                        state=4;
                    } else {
                        state=100;
                    }
                    break;
                case 8:
                    if(isdigit(c)){
                        state=6;
                    } else {
                        state=100;
                    }
                    break;
                case 100:
                    return false;
            }
        }
        if(state==1||state==4||state==6||state==3){
            return true;
        }
        return false;
    }

    private boolean isdigit(char c) {
        if(c>='0'&&c<='9'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidNumber_use_state_machine valid = new ValidNumber_use_state_machine();
        assertThat(true).isEqualTo(valid.isNumber("0"));
        assertThat(true).isEqualTo(valid.isNumber("0.1"));
        assertThat(false).isEqualTo(valid.isNumber("abc"));
        assertThat(false).isEqualTo(valid.isNumber("1 a"));
        assertThat(true).isEqualTo(valid.isNumber("2e10"));
        assertThat(true).isEqualTo(valid.isNumber(".1"));
        assertThat(true).isEqualTo(valid.isNumber("3."));

        assertThat(false).isEqualTo(valid.isNumber("."));
        assertThat(false).isEqualTo(valid.isNumber(". 2"));
    }
}
