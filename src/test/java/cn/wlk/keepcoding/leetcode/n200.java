package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 200. 岛屿的个数
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */

/**
 * 超时了
 */
public class n200 {
    public int numIslands(char[][] grid) {
        if(grid==null)
            return 0;

        int i = grid.length;
        if(i==0)
            return 0;
        int j = grid[0].length;
        int[][] flag   = new int[i][j];

        int sum = 0;
        int count = 0;
        for(int a=0;a<i;a++)
            for(int b=0;b<j;b++)
                flag[a][b]=0;


        for(int a=0;a<i;a++){
            for(int b=0;b<j;b++) {
                sum+=look(grid,flag,a,b);
            }
        }
        //  System.out.println(sum);
        return sum;

    }

    /**
     * 返回当前访问的坐标，是否为未被访问过的陆地
     * @param grid
     * @param flag
     * @param a
     * @param b
     * @return
     */
    public int look(char[][] grid,int[][] flag,int a,int b){
        int i = grid.length;
        int j = grid[0].length;
        if(a<0 || a>=i)
            return 0;
        if(b<0 || b>=j)
            return 0;

        if(grid[a][b]=='0')
            return 0;

        if(grid[a][b]=='1'){
            if(flag[a][b]==0) {
                flag[a][b] = 1;
                look(grid, flag, a - 1, b );
                look(grid, flag, a + 1, b );
                look(grid, flag, a , b - 1);
                look(grid, flag, a , b + 1);
            }else return 0;
        }
        return 1;
    }

    @Test
    public void test() {
        n200 t = new n200();
        System.out.println();
    }

}
