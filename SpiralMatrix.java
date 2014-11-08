import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 14-11-8.
 */
public class SpiralMatrix {
    private static int right = 1;
    private static int left = 2;
    private static int down = 3;
    private static int up = 4;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return result;
        }
        int[][] visited = new int[m][n];
        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                visited[i][j] = -1;
            }
        }
        i = 0;
        j = 0;
        visited[0][0] = 1;
        int position = right;
        while (true) {
            result.add(matrix[i][j]);
            if (position == right) {
                if (legal(i, j + 1, m, n, visited)) {
                    visited[i][j + 1] = 0;
                    j = j + 1;
                } else if (legal(i + 1, j, m, n, visited)) {
                    visited[i + 1][j] = 0;
                    i = i + 1;
                    position = down;
                } else {
                    break;
                }
            } else if (position == down) {
                if (legal(i + 1, j, m, n, visited)) {
                    visited[i + 1][j] = 0;
                    i = i + 1;
                } else if (legal(i, j - 1, m, n, visited)) {
                    visited[i][j - 1] = 0;
                    j = j - 1;
                    position = left;
                } else {
                    break;
                }
            } else if (position == left) {
                if (legal(i, j - 1, m, n, visited)) {
                    visited[i][j - 1] = 0;
                    j = j - 1;
                } else if (legal(i - 1, j, m, n, visited)) {
                    visited[i - 1][j] = 0;
                    i = i - 1;
                    position = up;
                } else {
                    break;
                }
            } else {
                if (legal(i - 1, j, m, n, visited)) {
                    visited[i - 1][j] = 0;
                    i = i - 1;
                } else if (legal(i, j + 1, m, n, visited)) {
                    visited[i][j + 1] = 0;
                    j = j + 1;
                    position = right;
                } else {
                    break;
                }
            }

        }
        return result;
    }

    private boolean legal(int i, int j, int m, int n, int[][] graph) {
        if (i >= 0 && i < m && j >= 0 && j < n && graph[i][j] == -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int m = 0;
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ++m;
            }
        }
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> result = new ArrayList<Integer>();
        result = spiralMatrix.spiralOrder(matrix);
        for (Integer i : result) {
            System.out.println(i + " ");
        }
    }
}
