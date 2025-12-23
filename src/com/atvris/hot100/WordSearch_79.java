package com.atvris.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索
 * @author zjh
 * @date 2025/12/23 12:32
 */
public class WordSearch_79 {

    List<Character> match = new ArrayList<>();

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length;j++) {
                boolean ma = backtrack(0, i, j, board, word);
                if (ma) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int k, int i, int j, char[][] board, String word) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '0';// 代表被访问过
        boolean r = false;
        if (i > 0) {
            r |= backtrack(k + 1, i - 1, j, board, word);
        }
        if (i < board.length - 1) {
            r |= backtrack(k + 1, i + 1, j, board, word);
        }
        if (j > 0) {
            r |= backtrack(k + 1, i, j - 1, board, word);
        }
        if (j < board[0].length - 1) {
            r |= backtrack(k + 1, i, j + 1, board, word);
        }
        board[i][j] = temp; // 恢复
        return r;
    }
}
