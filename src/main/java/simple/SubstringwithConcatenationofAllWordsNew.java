package simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bruce on 10/27/2015.
 */

/*
拿到每一个字符对应的一个set列表
 */
public class SubstringwithConcatenationofAllWordsNew {
    public List<Integer> findSubstring(String s, String[] words) {

        int wordsLength = words.length;

        int len = s.length();

        int wordLen = words[0].length();   //单词的长度

        //建立一个map与arrayList的对应关系

        //如果list的长度等于words.length则去检查两个是否一致
        Map<Integer,ArrayList<String>> comparedList = new HashMap<Integer, ArrayList<String>>();




        return new ArrayList<Integer>();
    }


}
