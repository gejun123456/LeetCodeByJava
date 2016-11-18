package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bruce on 6/8/2015.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> one = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (one.contains(board[i][j])) {
                    return false;
                } else {
                    one.add(board[i][j]);
                }
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            Set<Character> one = new HashSet<Character>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (one.contains(board[j][i])) {
                    return false;
                } else {
                    one.add(board[j][i]);
                }
            }
        }

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m * n / 9; i++) {
            Set<Character> one = new HashSet<Character>();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int u = i % (m / 3) * 3 + j;
                    int v = i / (m / 3) * 3 + k;
                    if (board[u][v] == '.') {
                        continue;
                    }
                    if (one.contains(board[u][v])) {
                        return false;
                    } else {
                        one.add(board[u][v]);
                    }
                }
            }
        }

        return true;

    }
}
