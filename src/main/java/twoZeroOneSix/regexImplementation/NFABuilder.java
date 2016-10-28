package twoZeroOneSix.regexImplementation;

import java.util.Map;
import java.util.Stack;

/**
 * Created by bruce.ge on 2016/10/28.
 */
public class NFABuilder {
    public static NFAUnit createNFA(String regex){
        String backRegex = RegexMatchToBack.getBackRegex(regex);

        Stack<NFAUnit> unitStack = new Stack<NFAUnit>();
        int[]  startState= new int[1];
        startState[0]=1;
        for (int i = 0; i < backRegex.length(); i++) {
            char c = backRegex.charAt(i);
            if(!RegexOperator.isOperator(c)){
                //create with default NFAUNIT.
                NFAUnit unit = new NFAUnit();
                unit.setStartState(startState[0]++);
                unit.setEndState(startState[0]++);
                unit.addPathToMap(unit.getStartState(),c,unit.getEndState());
                unitStack.push(unit);
            } else {
                if(RegexOperator.isLinkOperator(c)){
                    NFAUnit a = unitStack.pop();
                    NFAUnit b = unitStack.pop();
                    NFAUnit with = buildLinkNFA(a,b,c,startState);
                    unitStack.push(with);
                } else {
                    NFAUnit a = unitStack.pop();
                    NFAUnit single = buildSingleNFA(a,c,startState);
                    unitStack.push(single);
                }
            }
        }
        return unitStack.pop();
    }

    private static NFAUnit buildSingleNFA(NFAUnit a, char c,int[] startState) {
        NFAUnit unit = new NFAUnit();
        if(c=='*'){
            unit.setStartState(startState[0]++);
            unit.setEndState(startState[0]++);
            unit.buildMap(a);
            unit.addPathToMap(unit.getStartState(),'Ø',a.getStartState());
            unit.addPathToMap(unit.getStartState(),'Ø',unit.getEndState());
            unit.addPathToMap(a.getEndState(),'Ø',unit.getEndState());
            unit.addPathToMap(a.getEndState(),'Ø',a.getStartState());
        }
        return unit;
    }

    private static NFAUnit buildLinkNFA(NFAUnit a, NFAUnit b, char c, int[] startState) {
        NFAUnit unit = new NFAUnit();
        if(c=='|'){
            unit.setStartState(startState[0]++);
            unit.setEndState(startState[0]++);
            unit.buildMap(a,b);
            unit.addPathToMap(unit.getStartState(),'Ø',a.getStartState());
            unit.addPathToMap(unit.getStartState(),'Ø',b.getStartState());
            unit.addPathToMap(a.getEndState(),'Ø',unit.getEndState());
            unit.addPathToMap(b.getEndState(),'Ø',unit.getEndState());
        } else if(c=='-'){
            unit.setStartState(a.getStartState());
            unit.buildMap(a,b);
            unit.setEndState(b.getEndState());
            unit.addPathToMap(a.getEndState(),'Ø',b.getStartState());
        }
        return unit;
    }

    public static void main(String[] args) {
        NFAUnit ab = createNFA("ab");
        System.out.println("hello");
    }
}
