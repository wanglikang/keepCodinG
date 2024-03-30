package cn.wlk.keepcoding.niuke.TiBa;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

/**
 * 2020/4/3 16:22
 * author:WLK
 *
 * 牛妹的礼物
 * 题目描述
 * 众所周知，牛妹有很多很多粉丝，粉丝送了很多很多礼物给牛妹，牛妹的礼物摆满了地板。
 * 地板是N×MN\times MN×M的格子，每个格子有且只有一个礼物，牛妹已知每个礼物的体积。
 * 地板的坐标是左上角(1,1)  右下角（N, M）。
 * 牛妹只想要从屋子左上角走到右下角，每次走一步，每步只能向下走一步或者向右走一步或者向右下走一步
 * 每次走过一个格子，拿起（并且必须拿上）这个格子上的礼物。
 * 牛妹想知道，她能走到最后拿起的所有礼物体积最小和是多少？
 * 示例1
 * 输入
 * 复制
 *
 * [[1,2,3],[2,3,4]]
 *
 * 输出
 * 复制
 *
 * 7
 *
 * 说明
 *
 * (1,1)->(1,2)->(2,3)
 *
 * 备注:
 *
 * 0<N,M<300
 * 每个礼物的体积小于100
 *
 * 解法：简单dp即可
 *
 */

public class T2 {

    @Test
    public void test() {
        T2 t = new T2();
        int[][] in = Utils.createintInintFromString("[[1,2,3],[2,3,4]]");
        System.out.println(t.selectPresent(in));
    }
    /**
     *
     * @param presentVolumn int整型二维数组 N*M的矩阵，每个元素是这个地板砖上的礼物体积
     * @return int整型
     */
    public int selectPresent (int[][] presentVolumn) {
        if(presentVolumn==null || presentVolumn.length==0 ||presentVolumn[0].length ==0 ){
            return 0;
        }
        int n = presentVolumn.length;
        int m = presentVolumn[0].length;
        int[][] dp = new int[n][m];
        dp[0][0]=presentVolumn[0][0];
        for(int j = 1;j<m;j++){
            dp[0][j]=dp[0][j-1]+presentVolumn[0][j];
        }
        for(int i = 1;i<n;i++){
            dp[i][0] = dp[i-1][0]+presentVolumn[i][0];
        }

        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                dp[i][j] = Math.min(dp[i-1][j-1],
                        Math.min(dp[i-1][j], dp[i][j-1]))+presentVolumn[i][j];
            }
        }
        Utils.showArray(dp);
        return dp[n-1][m-1];
    }

}
