package com.aaron.algorithm.leecase;

/**
 * lc36. 有效的数独
 * 
 * @author huangbo
 * @date 2021/11/22
 */
public class LC00036_IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[10][10], col = new boolean[10][10], area = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int c = board[i][j];
                if (c == '.')
                    continue;
                int u = c - '0';
                int idx = i / 3 * 3 + j / 3;// 小方块编号和行列的关系
                if (row[i][u] || col[j][u] || area[idx][u])
                    return false;
                row[i][u] = col[j][u] = area[idx][u] = true;
            }
        }
        return true;
    }
}
