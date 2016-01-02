package simple;

import java.util.Arrays;

/**
 * Created by bruce on 14-11-10.
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len1 = A.length;
        int len2 = B.length;
        if (len1 == 0 && len2 == 0) {
            return 0;
        }
        if (len1 == 0) {
            return medianOfArr(B);
        }
        if (len2 == 0) {
            return medianOfArr(A);
        }
        if ((len1 + len2) % 2 == 1) {
            int k = (len1 + len2) / 2;
            return findAnum(A, B, len1, len2, k);
        } else {
            double first = findAnum(A, B, len1, len2, (len1 + len2) / 2);
            double second = findAnum(A, B, len1, len2, (len1 + len2) / 2 - 1);
            return (first + second) / 2;
        }
    }

    private double medianOfArr(int[] b) {
        if (b.length % 2 == 1) {
            return b[b.length / 2];
        } else {
            return ((double) (b[b.length / 2] + b[b.length / 2 - 1])) / 2;
        }
    }

    private double findAnum(int[] A, int[] B, int len1, int len2, int k) {
        int re = findByFirstArr(0, A.length - 1, A, k, B, len2);
        if (re != -1) {
            return re;
        } else {
            return findByFirstArr(0, B.length - 1, B, k, A, len1);
        }
    }

    private int findByFirstArr(int low, int high, int[] a, int k, int[] b, int len) {
        if (low == high) {
            int pos = k - low - 1;
            if (checkExist(len, pos)) {
                if (a[low] >= b[pos]) {
                    if ((pos + 1) >= len) {
                        return a[low];
                    } else {
                        if (a[low] <= b[pos + 1]) {
                            return a[low];
                        } else {
                            return -1;
                        }
                    }
                }
            } else if (checkExist(len, (pos + 1))) {
                if (a[low] <= b[pos + 1]) {
                    return a[low];
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            int mid = (low + high) / 2;
            int pos = k - mid - 1;
            if (checkExist(len, pos)) {
                if (a[mid] >= b[pos]) {
                    if ((pos + 1) == len) {
                        return a[mid];
                    } else {
                        if (a[mid] <= b[pos + 1]) {
                            return a[mid];
                        } else {
                            if (mid - 1 < low) {
                                return -1;
                            } else {
                                return findByFirstArr(low, mid - 1, a, k, b, len);
                            }
                        }
                    }
                } else {
                    return findByFirstArr(mid + 1, high, a, k, b, len);
                }
            } else if (checkExist(len, pos + 1)) {
                if (a[mid] <= b[pos + 1]) {
                    return a[mid];
                } else {
                    if (mid - 1 < low) {
                        return -1;
                    } else {
                        return findByFirstArr(low, mid - 1, a, k, b, len);
                    }
                }
            } else {
                if ((k - mid) < 0) {
                    if (mid - 1 < low) {
                        return -1;
                    } else {
                        return findByFirstArr(low, mid - 1, a, k, b, len);
                    }
                } else {
                    return findByFirstArr(mid + 1, high, a, k, b, len);
                }
            }
        }
        return -1;
    }

    private boolean checkExist(int len, int pos) {
        return pos >= 0 && pos < len;
    }

    public static void main(String[] args) {
        int A[] = {1, 3, 5, 89, 900};
        int B[] = {45, 57, 3423};
        int c[] = new int[A.length + B.length];
        for (int i = 0; i < A.length; i++) {
            c[i] = A[i];
        }
        for (int i = 0; i < B.length; i++) {
            c[i + A.length] = B[i];
        }
        Arrays.sort(c);
        if (c.length % 2 == 1) {
            System.out.println(c[c.length / 2]);
        } else {
            double x = (c[c.length / 2] + c[c.length / 2 - 1]) / 2;
            System.out.println(x);
        }
        MedianofTwoSortedArrays me = new MedianofTwoSortedArrays();
        double result = me.findMedianSortedArrays(A, B);
        System.out.println(result);
    }
}
