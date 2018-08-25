package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 764. 最大加号标志
 *
 * 在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。网格中包含 1 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。
 *
 * 一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。下面给出 k" 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。
 *
 *
 *
 * k 阶轴对称加号标志示例:
 *
 * 阶 1:
 * 000
 * 010
 * 000
 *
 * 阶 2:
 * 00000
 * 00100
 * 01110
 * 00100
 * 00000
 *
 * 阶 3:
 * 0000000
 * 0001000
 * 0001000
 * 0111110
 * 0001000
 * 0001000
 * 0000000
 *
 *
 * 示例 1：
 *
 * 输入: N = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释:
 *
 * 11111
 * 11111
 * 11111
 * 11111
 * 11011
 *
 * 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 *
 *
 * 示例 2：
 *
 * 输入: N = 2, mines = []
 * 输出: 1
 * 解释:
 *
 * 11
 * 11
 *
 * 没有 2 阶加号标志，有 1 阶加号标志。
 *
 *
 * 示例 3：
 *
 * 输入: N = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释:
 *
 * 0
 *
 * 没有加号标志，返回 0 。
 *
 *
 * 提示：
 *
 * 整数N 的范围： [1, 500].
 * mines 的最大长度为 5000.
 * mines[i] 是长度为2的由2个 [0, N-1] 中的数组成.
 * (另外,使用 C, C++, 或者 C# 编程将以稍小的时间限制进行​​判断.)
 *
 */
//done

/**
 * 解法：
 *      暴力即可，
 *      动态规划的解法是：未完待续
 *
 */
public class n764 {

    public int orderOfLargestPlusSign(int N, int[][] mines) {


        //转换一下，变成求0所组的最大加号

        int[][]dp = new int[N][N];
        for(int i = 0;i<mines.length;i++){
            dp[mines[i][0]][mines[i][1]]=1;
        }
        int mup,mdown,mleft,mright;

        int result = 0;
        int ti,tj;
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                ti = i;tj = j;
                mup=0;
                mdown=0;
                mleft=0;
                mright=0;
                while(ti>=0){
                    if(dp[ti][tj]==0)
                        mup++;
                    else if(dp[ti][tj]==1)
                        break;
                    ti--;

                }

                ti = i;tj = j;
                while(ti<N){
                    if(dp[ti][tj]==0)
                        mdown++;
                    else if(dp[ti][tj]==1)
                        break;
                    ti++;
                }

                ti = i;tj = j;
                while(tj>=0) {
                    if(dp[ti][tj]==0)
                        mleft++;
                    else if(dp[ti][tj]==1)
                        break;
                    tj--;
                }
                ti = i;tj = j;
                while(tj<N) {
                    if(dp[ti][tj]==0)
                        mright++;
                    else if(dp[ti][tj]==1)
                        break;
                    tj++;
                }

                result = Math.max(result,
                        Math.min(
                                Math.min(mup, mdown),
                                Math.min(mleft, mright)));

            }
        }
        return result;
    }

    @Test
    public void test() {
        n764 t = new n764();
        int[][] mines = Utils.createintInintFromString("[[0,0],[0,1],[0,4],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2],[2,3],[2,4],[3,0],[4,0],[4,1],[4,3],[4,4]]");
        System.out.println(t.orderOfLargestPlusSign(5,mines));
        System.out.println();
    }

}
