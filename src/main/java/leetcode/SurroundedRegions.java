package leetcode;

/**
 * Created by bruce on 14-11-18.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        if (n == 0) {
            return;
        }
        int[][] visited = new int[m][n];
        int[][] circle = new int[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][n - 1] = 1;
            visited[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            visited[m - 1][i] = 1;
            visited[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                circle[0][i] = 1;
                visited[0][i] = 1;
                findnext(1, i, board, circle, visited, m, n);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                circle[i][n - 1] = 1;
                visited[i][n - 1] = 1;
                findnext(i, n - 2, board, circle, visited, m, n);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (board[m - 1][i] == 'O') {
                circle[m - 1][i] = 1;
                visited[m - 1][i] = 1;
                findnext(m-2,i, board, circle, visited, m, n);
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            if (board[i][0] == 'O') {
                circle[i][0] = 1;
                visited[i][0] = 1;
                findnext(i, 1, board, circle, visited, m, n);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (circle[i][j] == 1) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void findnext(int i, int j, char[][] board, int[][] circle, int[][] visited, int m, int n) {
        if (i < m && j < n && i >= 0 && j >= 0) {
            if (visited[i][j] == 0 && board[i][j] == 'O') {
                circle[i][j] = 1;
                visited[i][j] = 1;
                findnext(i - 1, j, board, circle, visited, m, n);
                findnext(i + 1, j, board, circle, visited, m, n);
                findnext(i, j - 1, board, circle, visited, m, n);
                findnext(i, j + 1, board, circle, visited, m, n);
            }
            visited[i][j] = 1;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = 'X';
            }
        }
        board[1][1] = 'O';
        board[1][2] = 'O';
        board[2][2] = 'O';
        board[3][1] = 'O';
        SurroundedRegions su = new SurroundedRegions();
        su.solve(board);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
