package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
//done
public class n064 {
    public int minPathSum(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        int[][] dp = new int[i][j];
        dp[0][0] = grid[0][0];
        for(int a = 1;a<j;a++){
            dp[0][a] =dp[0][a-1]+grid[0][a];
        }
        for(int b = 1;b<i;b++){
            dp[b][0]=dp[b-1][0]+grid[b][0];
        }

        for(int a = 1;a<i;a++){
            for(int b = 1;b<j;b++){
                dp[a][b] = Math.min(
                        dp[a][b-1],dp[a-1][b])+grid[a][b];
            }
        }

        return dp[i-1][j-1];
    }
    @Test
    public void test() {
        n064 t = new n064();
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(t.minPathSum(grid));
        System.out.println();
    }

}
