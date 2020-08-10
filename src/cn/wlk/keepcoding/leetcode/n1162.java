package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2020/3/29 16:54
 * author:WLK
 *
 * 1162. 地图分析
 *
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 * 示例 2：
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *
 *
 *
 * 提示：
 *
 *     1 <= grid.length == grid[0].length <= 100
 *     grid[i][j] 不是 0 就是 1
 *
 *
 * 解法：统计轮次即可
 */

public class n1162 {

    @Test
    public void test() {
        n1162 t = new n1162();
        int[][] grid2 = new int[][]{
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };
        int[][] grid = new int[][]{
                {1,0,0},
                {0,0,0},
                {0,0,0}
        };
//        System.out.println(t.maxDistance(grid)+"-"+t.maxDistance2(grid));
//        System.out.println(t.maxDistance(grid2)+"-"+t.maxDistance2(grid2));
        System.out.println(t.maxDistance(grid));
    }

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedBlockingQueue<>();
        Queue<int[]> queue2 = new LinkedBlockingQueue<>();
        int maxLen = -1;
        int n  = grid.length;
        int count1 = 0;
        int[][] visited = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                visited[i][j] =0;
                if(grid[i][j]==1) {
                    //是陆地
                    queue.add(new int[]{i, j});
                    visited[i][j]=1;
                    count1++;
                }
            }
        }
        if(count1==n*n || count1==0){
            return -1;
        }
        int x=0,y=0;
        int count = 0;
        int xx = queue.peek()[0];
        int yy = queue.peek()[1];
        while (!queue.isEmpty() || !queue2.isEmpty()){
            while(!queue.isEmpty()) {
                int[] xy = queue.poll();
                x = xy[0];
                y = xy[1];

                if (x > 0 && visited[x - 1][y]==0) {visited[x-1][y]=1; queue2.add((new int[]{x - 1, y})); }
                if (x < n - 1 && visited[x+1][y]==0) {visited[x+1][y]=1; queue2.add((new int[]{x + 1, y})); }
                if (y > 0 && visited[x][y-1]==0) {visited[x][y-1]=1; queue2.add(new int[]{x, y - 1}); }
                if (y < n - 1 && visited[x][y+1]==0) { visited[x][y+1]=1; queue2.add(new int[]{x, y + 1}); }
            }
            Queue<int[]> q = queue;
            queue = queue2;
            queue2 = q;
            count++;
        }

        return count-1;
    }



    public int maxDistance2(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 取出队列的元素，将其四周的海洋入队。
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1; // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                hasOcean = true;
                queue.offer(new int[] {newX, newY});
            }
        }

        // 没有陆地或者没有海洋，返回-1。
        if (point == null || !hasOcean) {
            return -1;
        }

        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;

    }

}











