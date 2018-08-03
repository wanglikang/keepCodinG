package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 73. 矩阵置零
 * <p>
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 进阶:
 * <p>
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
//done
public class n073 {
    public void setcol(int[][] matrix, int col) {
        int i = matrix.length;
        for (int a = 0; a < i; a++) {
            matrix[a][col] = 0;
        }

    }

    public void setrow(int[][] matrix, int row) {
        int i = matrix.length;
        int j = matrix[0].length;
        for (int a = 0; a < j; a++) {
            matrix[row][a] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {

        int a = matrix.length;
        if (a == 0)
            return;
        int b = matrix[0].length;

        int[] row = new int[a];
        int[] col = new int[b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            if (row[i] == 1)
                setrow(matrix, i);
        }
        for (int i = 0; i < b; i++) {
            if (col[i] == 1)
                setcol(matrix, i);
        }
    }

    @Test
    public void test() {
        n073 t = new n073();
        int[][] matrix = {
                {0, 0, 0, 5},
                {2, 3, 3, 4},
                {0, 1, 2, 3},
                {1, 2, 3, 4},
                {0, 0, 1, 1}};
        t.setZeroes(matrix);
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}
