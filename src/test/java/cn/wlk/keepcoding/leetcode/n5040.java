package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 2019/4/28 10:52
 * author:WLK
 *
 * 第 134 场周赛 2
 * 5040. 边框着色
 *
 *
 * 给出一个二维整数网格 grid，网格中的每个值表示该位置处的网格块的颜色。
 *
 * 只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
 *
 * 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
 *
 * 给出位于 (r0, c0) 的网格块和颜色 color，使用颜色 color 为所给网格块的连通分量的边界进行着色，并返回最终的网格 grid 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * 输出：[[3, 3], [3, 2]]
 *
 * 示例 2：
 *
 * 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * 输出：[[1, 3, 3], [2, 3, 3]]
 *
 * 示例 3：
 *
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * 输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 *
 *
 *
 * 提示：
 *
 *     1 <= grid.length <= 50
 *     1 <= grid[0].length <= 50
 *     1 <= grid[i][j] <= 1000
 *     0 <= r0 < grid.length
 *     0 <= c0 < grid[0].length
 *     1 <= color <= 1000
 *
 * 解法：bfs即可
 *
 */
public class n5040 {
    @Test
    public void test() {
        n5040 t = new n5040();
//        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
//        int[][] grid = {{1,1},{1,2}};
        int[][] grid = {{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}};

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("--------------");
        int[][] result = t.colorBorder(grid, 1,3,1);
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }

        public int[][] colorBorder(int[][] grid, int x, int y, int color) {
            int[][] visited = new int[grid.length][grid[0].length];
            Queue<Integer> queuex = new LinkedBlockingDeque<>();
            Queue<Integer> queuey = new LinkedBlockingDeque<>();
            int startColor = grid[x][y];


            queuex.add(x);
            queuey.add(y);
            int xx,yy;

            while(!queuex.isEmpty()){
                xx = queuex.poll();
                yy = queuey.poll();
                visited[xx][yy]=1;
                boolean hasBoard = false;
                if(xx>0){
                    if(visited[xx-1][yy]!=1){
                        if(grid[xx-1][yy]!=startColor){
                            hasBoard = true;
                        }
                        if(grid[xx-1][yy]==startColor){
                            queuex.add(xx-1);
                            queuey.add(yy);
                        }
                    }
                }
                if(xx<grid.length-1){
                    if(visited[xx+1][yy]!=1){
                        if( grid[xx+1][yy]!=startColor){
                            hasBoard = true;
                        }
                        if(grid[xx+1][yy]==startColor){
                            queuex.add(xx+1);
                            queuey.add(yy);
                        }
                    }

                }
                if(xx==0 ||xx==grid.length-1){
                    hasBoard = true;
                }
                if(yy>0){
                    if(visited[xx][yy-1]!=1){
                        if(grid[xx][yy-1]!=startColor){
                            hasBoard = true;
                        }
                        if(grid[xx][yy-1]==startColor){
                            queuex.add(xx);
                            queuey.add(yy-1);
                        }
                    }

                }
                if(yy<grid[0].length-1){
                    if(visited[xx][yy+1]!=1){
                        if(grid[xx][yy+1]!=startColor){
                            hasBoard = true;
                        }
                        if(grid[xx][yy+1]==startColor){
                            queuex.add(xx);
                            queuey.add(yy+1);
                        }
                    }
                }
                if(yy==0 || yy==grid[0].length-1){
                    hasBoard = true;
                }
                if(hasBoard){
                    grid[xx][yy] = color;
                }
            }
            return grid;
        }

}