package cn.wlk.keepcoding.niuke.TiBa;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

/**
 * 2020/4/4 11:20
 * author:WLK
 *
 * 题目描述
 * 生产口罩
 *
 * 时间限制 :1sec / 空间限制: 256MB
 * 题意：
 *
 * 牛妹是一家口罩厂家的老板，由于现在疫情严重，牛妹想重新分配每条生产线上的人数来使得能生产的口罩最多。
 * 牛妹所在的公司一共有mmm名员工，nnn条生产线(0.....n-1)，每条生产线有strategy[i].size种人数安排策略。例如：333个人在aaa生产线上，aaa生产线每天生产888个口罩；555个人在aaa生产线上，每天aaa生产线能生产151515个口罩。
 * 牛妹想知道通过合理的策略安排最多每天能生产多少口罩？（可以不用将所有员工都分配上岗，生产线可以选择闲置）
 * 输入：
 *
 * 给定n,mn,mn,m，strategystrategystrategy数组
 * 1≤n,m≤2∗1031 \leq n,m \leq 2*10^{3} 1≤n,m≤2∗103
 * strategy[i].size≥1,∑i=0n−1strategy[i].size≤3000strategy[i].size \ge 1 , \sum_{i=0}^{n-1}strategy[i].size \leq 3000strategy[i].size≥1,∑i=0n−1​strategy[i].size≤3000
 * 1≤strategy[i][j].x≤2000,1≤strategy[i][j].y≤30001 \leq strategy[i][j].x \leq 2000,1 \leq strategy[i][j].y \leq 30001≤strategy[i][j].x≤2000,1≤strategy[i][j].y≤3000
 * strategy[i][j].x表示人数，strategy[i][j].y表示能生产的口罩数
 * 输出：
 * 返回每天最大的口罩生产数量
 *
 * 示例1
 * 输入
 * 复制
 *
 * 3,5,[[(1,3),(2,4)],[(3,4),(4,4)],[(8,8)]]
 *
 * 输出
 * 复制
 *
 * 8
 *
 * 说明
 *
 * 样例解释： 111号生产线采用策略222，222号生产线采用策略111，333号生产线不生产
 *
 *
 * 解法：类似01背包问题，只不过多每个物品，，多了不同的策略判断，选当前容量j下价值最大的策略拿
 */

public class T8 {
    public class Point {
      int x;
      int y;
      public Point(int x,int y){
      this.x = x;
      this.y = y;
      }
    }

    @Test
    public void test() {
        T8 t = new T8();
        int n = 3;
        int m = 5;
        //[[(1,3),(2,4)],[(3,4),(4,4)],[(8,8)]]
        Point[][] strategy = new Point[][]{
                {
                    new Point(1,3),
                        new Point(2,4)
                },
                {
                    new Point(3,4),
                        new Point(4,4)
                },
                {
                    new Point(8,8)
                }
        };
        System.out.println(t.producemask(n,m,strategy));
    }

    /**
     *
     * @param n int整型 n
     * @param m int整型 m
     * @param strategy Point类二维数组 策略
     * @return int整型
     */
    public int producemask (int n, int m, Point[][] strategy) {
        // write code here
        //01背包
        int[][] dp = new int[n][m+1];
        for(int j = 0;j<=m;j++){
            int maxV = 0;
            for(int k = 0;k<strategy[0].length;k++){
                if(j>=strategy[0][k].x){
                    maxV = Math.max(maxV,strategy[0][k].y);
                }
            }
            dp[0][j] = maxV;
        }
        for(int i = 1;i<n;i++){
            for(int j = m;j>0;j--){
                for(int k = 0;k<strategy[i].length;k++){
                    if(j>=strategy[i][k].x ) {
                        int t = Math.max(dp[i - 1][j],
                                dp[i - 1][j - strategy[i][k].x] + strategy[i][k].y);
                        dp[i][j] = Math.max(dp[i][j], t);
                    }else{
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
                    }
                }
            }
        }


        Utils.showArray(dp);

        return dp[n-1][m];
    }



}



