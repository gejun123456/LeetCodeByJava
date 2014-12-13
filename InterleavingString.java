/**
 * Created by bruce on 14-12-9.
 */
public class InterleavingString {
    int start;
    int end;
    int startA;
    int startB;
    int endA;
    int endB;
    int len;
    int lenA;
    int lenB;

    public boolean isInterleave(String s1, String s2, String s3) {
        lenA = s1.length();
        lenB = s2.length();
        len = s3.length();
        if (lenA + lenB != len) {
            return false;
        }
        startA = 0;
        startB = 0;
        start = 0;
        end = len - 1;
        endA = lenA - 1;
        endB = lenB - 1;
        return find(s1, s2, s3);
    }

    private boolean find(String s1, String s2, String s3) {
        if (start > end) {
            return true;
        }
        if (start == end) {
            return singleJudge(s1, s2, s3);
        } else {
            if (startA > endA) {
                if (startB < endB) {
                    if (s3.charAt(start) == s2.charAt(startB) && s3.charAt(end) == s2.charAt(endB)) {
                        setRegular();
                        if (find(s1, s2, s3) == true) {
                            return true;
                        } else {
                            removeRegular();
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (startA == endA) {
                if (s1.charAt(startA) != s3.charAt(start) && s1.charAt(endA) != s3.charAt(end)) {
                    if (startB < endB) {
                        if (s3.charAt(start) == s2.charAt(startB) && s3.charAt(end) == s2.charAt(endB)) {
                            setRegular();
                            if (find(s1, s2, s3) == true) {
                                return true;
                            } else {
                                removeRegular();
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (s1.charAt(startA) == s3.charAt(start) && s2.charAt(endB) == s3.charAt(end)) {
                    limit();
                    startA = startA + 1;
                    endB = endB - 1;
                    if (find(s1, s2, s3) == true) {
                        return true;
                    } else {
                        reset();
                        startA = startA - 1;
                        endB = endB + 1;
                    }
                }
                if (s1.charAt(endA) == s3.charAt(end) && s2.charAt(startB) == s3.charAt(start)) {
                    limit();
                    endA = endA - 1;
                    startB = startB + 1;
                    if (find(s1, s2, s3) == true) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            } else {
                if (s1.charAt(startA) == s3.charAt(start) && s1.charAt(endA) == s3.charAt(end)) {
                    limit();
                    startA = startA + 1;
                    endA = endA - 1;
                    if (find(s1, s2, s3) == true) {
                        return true;
                    } else {
                        reset();
                        startA = startA - 1;
                        endA = endA + 1;
                    }
                } else if (startB<=endB&&s1.charAt(startA) == s3.charAt(start) && s2.charAt(endB) == s3.charAt(end)) {
                    limit();
                    startA = startA + 1;
                    endB = endB - 1;
                    if (find(s1, s2, s3) == true) {
                        return true;
                    } else {
                        reset();
                        startA = startA - 1;
                        endB = endB + 1;
                    }
                } else if (startB<endB&&s2.charAt(startB) == s3.charAt(start) && s2.charAt(endB) == s3.charAt(end)) {
                    setRegular();
                    if (find(s1, s2, s3) == true) {
                        return true;
                    } else {
                        removeRegular();
                    }
                } else if (startB <= endB&&s2.charAt(startB) == s3.charAt(start) && s1.charAt(endA) == s3.charAt(end)) {
                    limit();
                    startB = startB + 1;
                    endA = endA - 1;
                    if (find(s1, s2, s3) == true) {
                        return true;
                    } else {
                       startB = startB-1;
                       endA = endA+1;
                    }
                }
            }
        }
        return false;
    }

    private void reset() {
        start = start - 1;
        end = end + 1;
    }

    private void limit() {
        start = start + 1;
        end = end - 1;
    }

    private boolean singleJudge(String s1, String s2, String s3) {
        if (endA == startA) {
            if (s1.charAt(startA) == s3.charAt(start)) {
                return true;
            } else {
                return false;
            }
        } else if (endB == startB) {
            if (s2.charAt(startB) == s3.charAt(start)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void removeRegular() {
        reset();
        startB = startB - 1;
        endB = endB + 1;
    }

    private void setRegular() {
        limit();
        startB = startB + 1;
        endB = endB - 1;
    }

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "ab";
        String s3 = "abaa";
        getResult(s1, s2, s3);
//        s3 = "aadbbbaccc";
//        getResult(s1, s2, s3);
    }

    private static void getResult(String s1, String s2, String s3) {
        boolean re;
        re = new InterleavingString().isInterleave(s1, s2, s3);
        System.out.println(re);
    }
}
