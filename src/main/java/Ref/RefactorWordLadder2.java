package Ref;

import java.util.*;

/**
 * Created by Administrator on 14-11-1.
 */
public class RefactorWordLadder2 {
    public class node {
        String value;
        node next;
        int used;
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<node> solution = new ArrayList<node>();
        node first = new node();
        first.value = end;
        first.used = -1;
        solution.add(first);
        dict.remove(start);
        dict.remove(end);
        result = search(solution, start, dict);
        return result;
    }

    private List<List<String>> search(List<node> nodeList, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<node> realResult = new ArrayList<node>();
        List<node> currentResult = new ArrayList<node>();
        List<String> endResult = compute(end);
        List<String> deleted = new ArrayList<String>();
        int k = 0;
        for (node so : nodeList) {
            if (endResult.contains(so.value)) {
                node ss = new node();
                ss.value = end;
                ss.next = so;
                realResult.add(ss);
                k = 1;
            }
        }
        if (k == 1) {
            for (node so : realResult) {
                List<String> sol = new ArrayList<String>();
                while (so != null) {
                    sol.add(so.value);
                    so = so.next;
                }
                result.add(sol);
            }
            return result;
        } else {
            for (node so : nodeList) {
                String p = so.value;
                for (int i = 0; i < p.length(); i++) {
                    if (so.used == i) {
                        continue;
                    }
                    for (char c = 'a'; c <= 'z'; c++) {
                        String str = p.substring(0, i) + c + p.substring(i + 1, p.length());
                        if (dict.contains(str)) {
                            deleted.add(str);
                            node ss = new node();
                            ss.value = str;
                            ss.next = so;
                            ss.used = i;
                            currentResult.add(ss);
                            deleted.add(str);
                        }
                    }
                }
//                for (String s : computeNode(so)) {
//                    if (dict.contains(s)) {
//
//                    }
//                }
            }
            if (currentResult.size() == 0) {
                return result;
            }
            for (String s : deleted) {
                dict.remove(s);
            }
            return search(currentResult, end, dict);
        }
    }

    private List<String> compute(String p) {
        List<String> near = new ArrayList<String>();
        int l = p.length();
        for (int i = 0; i < l; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != p.charAt(i)) {
                    String r = p.substring(0, i) + c + p.substring(i + 1, l);
                    near.add(r);
                }
            }
        }
        return near;
    }

    public static void main(String[] args) {
        RefactorWordLadder2 wordLadder = new RefactorWordLadder2();
        List<List<String>> result = new ArrayList<List<String>>();
        String[] dictArr = {"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"};

        Set<String> dict = new HashSet<String>();
        for(int i = 0;i<dictArr.length;i++) {
            dict.add(dictArr[i]);
        }
        result = wordLadder.findLadders("cet", "ism", dict);
        System.out.println(result.size());
        for (List<String> solution : result) {
            for (String s : solution) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
