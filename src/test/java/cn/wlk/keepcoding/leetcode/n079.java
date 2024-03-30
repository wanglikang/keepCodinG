package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
//done

/**
 * 解法：
 *      暴力回溯即可
 */
public class n079 {
    public void reSet(int[][] arr, int value) {
        for (int[] col : arr) {
            for (int i = 0; i < col.length; i++) {
                col[i] = value;
            }
        }
    }

    public boolean dfs(char[][] board, char[] words, int start, int end, int[][] isUsed, int i, int j) {
        if (start > end)
            return true;

        int rowlen = board.length;
        int collen = board[0].length;
        if (i < 0 || i >= rowlen)
            return false;
        if (j < 0 || j >= collen)
            return false;

        if (i > 0 && board[i - 1][j] == words[start]) {//上
            if (isUsed[i - 1][j] == 0) {
                isUsed[i - 1][j] = 1;
                if (!dfs(board, words, start + 1, end, isUsed, i - 1, j))
                    isUsed[i - 1][j] = 0;
                else
                    return true;
            }
        }
        if (j < collen - 1 && board[i][j + 1] == words[start]) {//右
            if (isUsed[i][j + 1] == 0) {
                isUsed[i][j + 1] = 1;
                if (!dfs(board, words, start + 1, end, isUsed, i, j + 1))
                    isUsed[i][j + 1] = 0;
                else
                    return true;
            }
        }
        if (i < rowlen - 1 && board[i + 1][j] == words[start]) {//下
            if (isUsed[i + 1][j] == 0) {
                isUsed[i + 1][j] = 1;
                if (!dfs(board, words, start + 1, end, isUsed, i + 1, j))
                    isUsed[i + 1][j] = 0;
                else
                    return true;
            }
        }
        if (j > 0 && board[i][j - 1] == words[start]) {//左
            if (isUsed[i][j - 1] == 0) {
                isUsed[i][j - 1] = 1;
                if (!dfs(board, words, start + 1, end, isUsed, i, j - 1))
                    isUsed[i][j - 1] = 0;
                else
                    return true;
            }
        }
        return false;

    }

    public boolean exist(char[][] board, String word) {
        int i = board.length;
        if (i == 0)
            return false;
        int j = board[0].length;
        int[][] isUsed = new int[i][j];
        char[] words = word.toCharArray();
        int len = words.length;
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                reSet(isUsed, 0);
                if (word.toCharArray()[0] == board[a][b]) {
                    isUsed[a][b] = 1;
                    if (dfs(board, words, 1, len - 1, isUsed, a, b))
                        return true;
                }
            }
        }


        return false;
    }

    @Test
    public void test() {
        n079 t = new n079();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(t.exist(board, "ABC"));
        System.out.println(t.exist(board, "ABCCEDA"));

        char[][] board2 = {{'a', 'a'}};
        System.out.println(t.exist(board2, "aaa"));

        System.out.println();
    }

}
