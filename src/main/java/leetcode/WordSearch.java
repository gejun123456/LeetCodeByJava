package leetcode;

/**
 * Created by Administrator on 14-10-26.
 */

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        int[][] q = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                q[i][j] = 0;
            }
        }
        if (word.length() == 0) {
            return true;
        } else {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (board[i][j] == word.charAt(0) && word.length() == 1) {
                        return true;
                    } else if (board[i][j] == word.charAt(0)) {
                        q[i][j] = 1;
                        int result = search(i, j, x, y, q, board, word.substring(1));
                        if (result == 1) {
                            return true;
                        } else
                            q[i][j] = 0;
                    }
                }
            }
        }
        return false;
    }

    private int search(int i, int j, int x, int y, int[][] q, char[][] board, String sub) {
        int[] a = {i - 1, i + 1, i, i};
        int[] b = {j, j, j - 1, j + 1};
        if (sub.length() == 1) {
            for (int m = 0; m < a.length; m++) {
                if (check(a[m], b[m], x, y, q, board, sub.charAt(0)))
                    return 1;
            }
            return 0;
        } else {
            for (int m = 0; m < a.length; m++) {
                if (check(a[m], b[m], x, y, q, board, sub.charAt(0))) {
                    q[a[m]][b[m]] = 1;
                    int result = search(a[m], b[m], x, y, q, board, sub.substring(1));
                    if (result == 1) {
                        return 1;
                    } else {
                        q[a[m]][b[m]] = 0;
                    }
                }
            }
            return 0;
        }
    }

    private boolean check(int i, int j, int x, int y, int[][] q, char[][] board, char c) {
        if (i < x && i>=0&&j>=0&&j < y && q[i][j] == 0 && board[i][j] == c) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board[0][0] = 'A';
        board[0][1] = 'B';
        board[0][2] = 'C';
        board[0][3] = 'E';
        board[1][0] = 'S';
        board[1][1] = 'F';
        board[1][2] = 'C';
        board[1][3] = 'S';
        board[2][0] = 'A';
        board[2][1] = 'D';
        board[2][2] = 'E';
        board[2][3] = 'E';
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCCED"));
        System.out.println(wordSearch.exist(board, "SEE"));
        System.out.println(wordSearch.exist(board, "ABCB"));
    }

}
