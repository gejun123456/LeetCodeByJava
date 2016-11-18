package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 14-12-17.
 */
public class UseArray {
    public static List<Integer> bfs(int arr[][]) {
        List<Integer> result = new ArrayList<Integer>();
        int len1 = arr.length;
        int len2 = arr[0].length;
        int queue[] = new int[len1];
        int left = 0 ;
        int right = 1;
        queue[left] = 0;
        int visited[] = new int[len1];
        visited[0] = 1;
        while(left<right) {
            int point = queue[left++];
            for(int i = 0; i< len1; i++) {
                if(i==point){
                    continue;
                }
                if(visited[i]==0&&arr[point][i]==1) {
                    queue[right++] = i;
                    visited[i] = 1;
                }
            }
            result.add(point);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[][] = new int[10][10];
        arr[0][1] = 1;
        arr[1][5] = 1;
        arr[2][7] = 1;
        arr[3][8] = 1;
        arr[5][9] = 1;
        arr[7][9] = 1;
        arr[1][3] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(i==j) {
                    arr[i][j] = 0;
                } else{
                    arr[i][j] = arr[j][i];
                }
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.printf(arr[i][j]+ " ");
//            }
//        }

        List<Integer> result = bfs(arr);
        for (Integer i : result) {
            System.out.printf(i + " ");
        }
    }
}
