package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**s
 * 2020/1/29 13:16
 * author:WLK
 * 63. 不同路径 II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：动态规划，注意有障碍物的坐标对临近位置的影响
 *
 */

public class n063 {

    @Test
    public void test() {
        n063 t = new n063();
//        int[][] input = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] input = new int[][]{{0,1}};
        int re = t.uniquePathsWithObstacles(input);
        System.out.println(re);
    }
    public int uniquePathsWithObstacles(int[][] in) {
        int result = 0;
        int h = in.length;
        if(h>0) {
            int w = in[0].length;
            int[][] dp = new int[h][w];
            dp[0][0] = in[0][0]==1?0:1;
            for(int j = 1;j<w;j++){
                dp[0][j] = in[0][j-1]==1?0:dp[0][j-1];
            }
            for(int i  = 1;i<h;i++){
                dp[i][0] = in[i-1][0]==1?0:dp[i-1][0];
            }

            for(int i = 1;i<h;i++){
                for(int j = 1;j<w;j++){
                    dp[i][j] = in[i][j]==1?0:
                            (in[i][j-1]==1?0:dp[i][j-1])
                            +(in[i-1][j]==1?0:dp[i-1][j]);
                }
            }

            return in[h-1][w-1]==1?0:dp[h-1][w-1];
        }else {
            return 0;
        }


    }


}
