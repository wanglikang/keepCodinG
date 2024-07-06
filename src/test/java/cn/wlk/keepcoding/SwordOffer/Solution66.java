package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/9-14:31
 * author:WLK
 * 机器人的运动范围
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 解法：广度优先搜索，BFS即可，设visited，每次只用置为1，不用置回0
 */
public class Solution66 {
    @Test
    public void test() {
        Solution66 t = new Solution66();
        System.out.println(t.movingCount(5, 10, 10));
    }

    public int sumOfN(int n) {
        int result = 0;
        while (n != 0) {
            result += n % 10;
            n = n / 10;
        }
        return result;
    }

    public int movingCount(int threshold, int rows, int cols) {
        int[][] visited = new int[rows][cols];
        return isAvaliable(threshold, rows, cols, 0, 0, visited);
    }

    //返回x，y可用到达的数量
    public int isAvaliable(int threshold, int rows, int cols, int x, int y, int[][] visited) {
        int result = 0;
        visited[x][y] = 1;
        if (sumOfN(x) + sumOfN(y) <= threshold) {
            result++;
        }else{
            visited[x][y] = 0;
            return  result;
        }
        if (x - 1 >= 0 && visited[x - 1][y] != 1) {
            result += isAvaliable(threshold, rows, cols, x - 1, y, visited);
        }
        if (x + 1 < rows && visited[x + 1][y] != 1) {
            result += isAvaliable(threshold, rows, cols, x + 1, y, visited);
        }
        if (y - 1 >= 0 && visited[x][y - 1] != 1) {
            result += isAvaliable(threshold, rows, cols, x, y - 1, visited);
        }
        if (y + 1 < cols && visited[x][y + 1] != 1) {
            result += isAvaliable(threshold, rows, cols, x, y + 1, visited);
        }
        return result;
    }

}