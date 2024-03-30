package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/7/4 9:38
 * author:WLK
 * <p>
 * 695. 岛屿的最大面积
 * <p>
 * <p>
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 示例 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * <p>
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * <p>
 * 示例 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * <p>
 * 对于上面这个给定的矩阵, 返回 0。
 * <p>
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：递归搜索即可
 */
public class n695 {
    @Test
    public void test() {
        n695 t = new n695();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int re = t.maxAreaOfIsland(grid);
        System.out.println(re);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }

        int cols = grid[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        int maxGrid = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!isVisited[i][j]) {
                    maxGrid = Math.max(maxGrid, search(grid, isVisited, i, j));
                }
            }
        }
        return maxGrid;
    }

    public int search(int[][] grid, boolean[][] visited, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;
        int sumGrid = 0;
        if (grid[x][y] == 1) {
            sumGrid=1;
            visited[x][y] = true;
            if (x - 1 >= 0 && !visited[x - 1][y]) {
                sumGrid += search(grid, visited, x - 1, y);
            }
            if (x + 1 < rows && !visited[x + 1][y]) {
                sumGrid += search(grid, visited, x + 1, y);
            }
            if (y - 1 >= 0 && !visited[x][y - 1]) {
                sumGrid += search(grid, visited, x, y - 1);
            }
            if (y + 1 < cols && !visited[x][y + 1]) {
                sumGrid += search(grid, visited, x, y + 1);
            }
        }
        return sumGrid;
    }


}