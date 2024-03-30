package cn.wlk.keepcoding.niuke.TiBa;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2020/4/3 22:00
 * author:WLK
 *
 * 牛妹做衣服
 *
 * 题目描述
 * 众所周知，牛妹需要很多衣服，有直播的时候穿的、有舞剑的时候穿的、有跳舞的时候穿的、有弹琴的时候穿的，等等
 * 这些衣服都是由固定大小的矩形布料裁剪而成，心灵手巧的牛妹也知道每件衣服所需要的具体矩形布料的长和宽
 * 然而，她只有一块大的布料可供她裁剪。裁剪的时候可以随便剪
 * 那么问题来了，美腻的牛妹能最多可以做出多少件衣服呢？
 *
 *
 * 示例1
 * 输入
 * 复制
 *
 * 3,5,[[3 ,1],[4,1],[2,2],[2,2]]
 *
 * 输出
 * 复制
 *
 * 5
 *
 * 备注:
 *
 * 1.布料使用时无方向要求，但是 不可以把边角料拼成大布料
 * 2.每种衣服牛妹可以不止要一件
 *
 * 数据保证 ：
 *
 * 0 < 衣服件数 <=10
 *
 * 0 < 大布料的长&宽，每件衣服长&宽  <= 1000  均为整数
 *
 * 解法：还是使用动态规划，类似01背包问题，但是是二维的
 * 参考：https://www.nowcoder.com/questionTerminal/9053c1dc96e5480e8a4d2a63e34c45d0?answerType=1&f=discussion
 *
 */

public class T7 {


    @Test
    public void test() {
        T7 t = new T7();
//        int L = 3;
//        int W = 5;
//        int[][] clothSize = Utils.createintInintFromString("[[3 ,1],[4,1],[2,2],[2,2]]");
//
        int L = 7;
        int W = 7;
        int[][]  clothSize = Utils.createintInintFromString("[[2,2],[2,3],[3,2],[2,2],[6,1],[7,1],[4,4],[5,1],[5,2],[5,3]]");
        System.out.println(t.clothNumber(L,W,clothSize));
    }

    /**
     *
     * @param L int整型 给定布料的长
     * @param W int整型 给定布料的宽
     * @param clothSize int整型二维数组 依次列举每件衣服所需的长和宽
     * @return int整型
     */
    public int clothNumber (int L, int W, int[][] clothSize) {
        int n =clothSize.length;
        if(n==0){
            return 0;
        }
        int[][] dp = new int[L+1][W+1];
        for(int i = 0;i<=L;i++){
            for(int j = 0;j<=W;j++){
                for(int k = 0;k<n;k++){
                    if(i>=clothSize[k][0] && j>=clothSize[k][1]){
                            dp[i][j] = Math.max(dp[i][j],
                                    Math.max(
                                            dp[i][j - clothSize[k][1]] + dp[i - clothSize[k][0]][clothSize[k][1]] + 1,
                                            dp[clothSize[k][0]][j - clothSize[k][1]] + dp[i - clothSize[k][0]][j] + 1)
                            );
                    }
                    if(i>=clothSize[k][1] && j>=clothSize[k][0]){
                        dp[i][j] = Math.max(dp[i][j],
                                Math.max(
                                        dp[i][j-clothSize[k][0]]+dp[i-clothSize[k][1]][clothSize[k][0]]+1,
                                        dp[clothSize[k][1]][j-clothSize[k][0]]+dp[i-clothSize[k][1]][j]+1
                                ));
                    }
                }
            }
        }

        return dp[L][W];
    }

}
