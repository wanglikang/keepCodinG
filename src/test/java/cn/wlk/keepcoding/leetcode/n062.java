package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/description/
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 */

//done

/**
 * 解法：
 *      设dp数组int dp[m+1][n+1]，
 *      dp[i][j]代表从(1,1)点开始到(i,j)的路径数
 *      因为只能向下或向右走，，所以dp的递推式为：
 *          dp[i][j] = dp[i][j-1]
 *                      +dp[i-1][j]
 *      此外，初始化dp[1][x]为1，dp[x][1]为1，dp[1][1]为0即可
 */
public class n062 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        if(m==1||n==1)
            return 1;


        for (int i = 1; i <= m; i++)
            dp[i][1] = 1;
        for (int j = 1; j <= n; j++)
            dp[1][j] = 1;

        dp[1][1] = 0;
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] =
                        dp[i][j-1]
                        +dp[i-1][j];
            }
        }


        return dp[m][n];
    }

    @Test
    public void test() {
        n062 t = new n062();
//        System.out.println(t.uniquePaths(3,2));
        System.out.println(t.uniquePaths(7,3));
    }

}
