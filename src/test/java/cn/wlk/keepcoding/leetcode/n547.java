package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/7/4 11:45
 * author:WLK
 * <p>
 * 547. 朋友圈
 * <p>
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * <p>
 * 注意：
 * <p>
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-circles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：遍历即可，设visited数组
 */
public class n547 {
    @Test
    public void test() {
        n547 t = new n547();
        int[][] M =
                {
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                };
//       int[][] M =
//                {
//                        {1, 0, 0, 1},
//                        {0, 1, 1, 0},
//                        {0, 1, 1, 1},
//                        {1, 0, 1, 1}
//                };
        int re = t.findCircleNum(M);
        System.out.println(re);
    }

    public int findCircleNum(int[][] M) {
        int count = 0;
        int rows = M.length;
        if (rows == 0) {
            return 0;
        }
        int cols = M[0].length;
        boolean[][] isvisited = new boolean[rows][cols];
        int sumGroup = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                if (!isvisited[i][j] && M[i][j] == 1) {//朋友关系且关系没访问过
                    search(M, rows, cols, isvisited, i, j);
                    sumGroup++;
                }
            }
        }
        return sumGroup;

    }

    public int search(int[][] M, int rows, int cols, boolean[][] isvisited, int x, int y) {
        isvisited[x][y] = true;
        int sum = 1;

        for (int i = x + 1; i <= y; i++) {//往下访问
            if (!isvisited[i][y] && M[i][y] == 1) {
                sum += search(M, rows, cols, isvisited, i, y);
            }
        }
        for (int i = x - 1; i>=0 ; i--) {//往上访问
            if (!isvisited[i][y] && M[i][y] == 1) {
                sum += search(M, rows, cols, isvisited, i, y);
            }
        }
        for (int j = y + 1; j < cols; j++) {//向右访问
            if (!isvisited[x][j] && M[x][j] == 1) {
                sum += search(M, rows, cols, isvisited, x, j);
            }
        }
        for (int j = y - 1; j >= x; j--) {//向左访问
            if (!isvisited[x][j] && M[x][j] == 1) {
                sum += search(M, rows, cols, isvisited, x, j);
            }
        }
        return sum;

    }

}