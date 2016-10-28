package twoZeroOneSix.regexImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bruce.ge on 2016/10/28.
 */

//can build with nfa. may be converted to dfa.
public class NFAUnit {
    private int startState;

    private int endState;

    //从一个state通过key 可以到的state. 需要是一个List 看来
    private Map<Integer,Map<Character,List<Integer>>> jumpMap;

    public int getStartState() {
        return startState;
    }

    public void setStartState(int startState) {
        this.startState = startState;
    }

    public int getEndState() {
        return endState;
    }

    public void setEndState(int endState) {
        this.endState = endState;
    }

    public Map<Integer, Map<Character, List<Integer>>> getJumpMap() {
        return jumpMap;
    }

    public void setJumpMap(Map<Integer, Map<Character, List<Integer>>> jumpMap) {
        this.jumpMap = jumpMap;
    }

    public void addPathToMap(int startState,char c, int endState){
        if(jumpMap==null){
            jumpMap = new HashMap<Integer, Map<Character, List<Integer>>>();
        }
        if(jumpMap.get(startState)==null){
            Map<Character,List<Integer>> aa = new HashMap<Character, List<Integer>>();
            jumpMap.put(startState,aa);
        }
        List<Integer> integers = jumpMap.get(startState).get(c);
        if(integers==null){
            jumpMap.get(startState).put(c,new ArrayList<Integer>());
        }

        jumpMap.get(startState).get(c).add(endState);
    }

    //if can't find return -1;  //find by char.
    public StateRoute getEndStateByStateAndC(int startState,char c){
        if(jumpMap==null&&jumpMap.size()==0){
            return null;
        }
        Map<Character, List<Integer>> startStateMap = jumpMap.get(startState);
        if(startStateMap ==null|| startStateMap.size()==0){
            return null;
        }

        if(startStateMap.get(c)==null||startStateMap.get(c).size()==0){
            return null;
        }
        StateRoute route = new StateRoute();
        route.setRoutes(startStateMap.get(c));
        return route;
    }

    public void buildMap(NFAUnit a, NFAUnit b) {
        if(jumpMap==null){
            jumpMap=new HashMap<Integer, Map<Character, List<Integer>>>();
        }
        jumpMap.putAll(a.getJumpMap());
        jumpMap.putAll(b.getJumpMap());
    }

    public void buildMap(NFAUnit a) {
        if(jumpMap==null){
            jumpMap=new HashMap<Integer, Map<Character, List<Integer>>>();
        }
        jumpMap.putAll(a.getJumpMap());
    }
}
