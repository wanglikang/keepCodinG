package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 48. 旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
//done
public class n048 {
    public void swap(int[][] matrix, int i, int j, int a, int b) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[a][b];
        matrix[a][b] = t;
    }

    public void roBox(int[][] matrix, int i, int j, int n) {

//       System.out.println(i+":"+j+":"+n);
        for (int a = 0; a < n - 1; a++) {
            swap(matrix, i, j + 1 + a, i + 1 + a, j + n - 1);

        }
        for (int a = 0; a < n - 1; a++) {
            swap(matrix, i + n - 1, j + n - 1 - 1 - a, i + n - 2 - a, i);
        }
        for (int a = 0; a < n - 1; a++) {
            swap(matrix, i, j + 1 + a, i + n - 1, j + n - 2 - a);
        }

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            roBox(matrix, i, i, n - 2 * i);
        }

    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        int[][] matrix2 = {{1,2},{3,4}};
        n048 n = new n048();
        n.rotate(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            Utils.showArray(matrix2[i]);
        }

    }

}
