package woj;

import java.util.Scanner;

/**
 * Created by bruce on 6/24/2015.
 */
public class SortingAlgorithm {
    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        while (cin.hasNext()) {
//            int n = cin.nextInt();
//            int i, j;
//            int arr[] = new int[n];
//            for (int k = 0; k < n; k++) {
//                arr[k] = cin.nextInt();
//            }
//            quickSort(arr, 0, n);
//            for (int k = 0; k < n-1; k++) {
//                System.out.print(arr[k]+" ");
//            }
//            System.out.println(arr[n-1]);
//        }
        int arr[] = {1,0,1,0,2,4,3,12,423,122,321,-432,321};
        quickSort(arr,0,arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int a = left;
        int b = right;
        int x = arr[left];
        while (a < b) {
            while (a < b && arr[--b] > x) ;  //为何不是等价的   x只是arr[left]的值而已
            if (a<b) {     //应该交换的时候没有交换出现问题
                arr[a] = arr[b];
            }
            while (a < b && arr[++a] < x) ;
            if (a<b) {
                arr[b] = arr[a];
            }
        }
        arr[a] = x;
        quickSort(arr, left, a);
        quickSort(arr, a + 1, right);

    }
}
