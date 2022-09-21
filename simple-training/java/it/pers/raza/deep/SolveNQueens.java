package it.pers.raza.deep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {
    /**
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     * <p>
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/n-queens
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        List<String> border = new ArrayList<>(n);
        for (int i = 0; i <= n - 1; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            border.add(new String(row));
        }
        backTrack(border, 0);
    }

    private void backTrack(List<String> board, int row) {
        if (row == board.size()) {
            res.add(board);
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board.get(row).(col, "Q");
            // 进入下一行决策
            backTrack(board, row + 1);
            // 撤销选择
            board.get(row).set(col, ".");
        }
    }

    /* 是否可以在 board[row][col] 放置皇后？ */
    boolean isValid(List<List<String>> board, int row, int col) {
        int n = board.size();
        // 检查列是否有皇后互相冲突
        for (int i = 0; i <= row; i++) {
            if (board.get(i).get(col).equals('Q')) {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board.get(i).get(j).equals('Q')) {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).get(j).equals('Q')) {
                return false;
            }
        }
        return true;
    }
}
