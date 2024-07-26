package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 221. 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 *
 *
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 *
 * 2024/7/26 20:23
 * author:nx
 */

/**
 * 解法：
 *     使用动态规划，dp[i][j] 表示以i,j为正方形右下角的时候，最长的边长度
 *     转移方程为：dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
 */
public class n0221 {

    //TODO  待提交代码
    public int maximalSquare(char[][] matrix) {

        return -1;
    }

    @Test
    public void test() {
        n0221 t = new n0221();
    }

}
