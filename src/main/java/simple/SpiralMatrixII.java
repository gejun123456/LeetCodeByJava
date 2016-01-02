package simple;

/**
 * Created by bruce on 14-11-7.
 */
public class SpiralMatrixII {
    private static int right = 1;
    private static int left = 2;
    private static int down = 3;
    private static int up = 4;

    public int[][] generateMatrix(int n) {
        int[][] graph = new int[n][n];
        if(n==0) {
            return graph;
        }
        int i, j;
        int position = right;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                graph[i][j] = -1;
            }
        }
        i = 0;
        j = 0;
        graph[0][0] = 1;
        int m = 2;
        while (true) {
            if (position == right) {
                if (legal(i, j+1, n, graph)) {
                    graph[i][j+1] = m++;
                    j = j + 1;
                } else if (legal(i+1, j, n, graph)) {
                    graph[i+1][j ] = m++;
                    i = i + 1;
                    position = down;
                } else {
                    break;
                }
            }
            else if (position == down) {
                if (legal(i+1, j , n, graph)) {
                    graph[i+1][j] = m++;
                    i = i + 1;
                } else if (legal(i, j-1, n, graph)) {
                    graph[i ][j-1] = m++;
                    j = j - 1;
                    position = left;
                } else {
                    break;
                }
            }
            else if (position == left) {
                if(legal(i,j-1,n,graph)) {
                    graph[i][j-1] = m++;
                    j = j -1;
                } else if(legal(i-1,j,n,graph)) {
                    graph[i-1][j] = m++;
                    i = i -1;
                    position = up;
                } else {
                    break;
                }
            }
            else {
                if(legal(i-1,j,n,graph)) {
                    graph[i-1][j] = m++;
                    i = i-1;
                } else if(legal(i,j+1,n,graph)) {
                    graph[i][j+1] = m++;
                    j = j+1;
                    position=right;
                } else {
                    break;
                }
            }

        }
        return graph;
    }

    private boolean legal(int i, int j, int n, int[][] graph) {
        if (i >= 0 && i < n && j >= 0 && j < n && graph[i][j] == -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int[][] graph = new int[6][6];
        graph = spiralMatrixII.generateMatrix(6);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println("");
        }
    }

}
