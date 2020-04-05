package cn.wlk.keepcoding.niuke.TiBa;

import cn.wlk.keepcoding.basealgorithm.P01beibao;
import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

/**
 * 2020/4/3 14:47
 * author:WLK
 *
 * 牛能和牛可乐的礼物
 * 题目描述
 * 众所周知，牛能和牛可乐经常收到小粉丝们送来的礼物，每个礼物有特定的价值，他俩想要尽可能按照自己所得价值来平均分配所有礼物。
 *
 * 那么问题来了，在最优的情况下，他俩手中得到的礼物价值和的最小差值是多少呢？
 * p.s 礼物都很珍贵，所以不可以拆开算哦
 *
 * 示例1
 * 输入
 * 复制
 *
 * [1,2,3,4]
 *
 * 输出
 * 复制
 *
 * 0
 *
 * 说明
 *
 * 他俩一个人拿1,4 。另一个人拿2,3
 *
 * 示例2
 * 输入
 * 复制
 *
 * [1,3,5]
 *
 * 输出
 * 复制
 *
 * 1
 *
 * 说明
 *
 * 他俩一个人拿1，3.另一个人拿5
 *
 * 备注:
 *
 * 单个礼物价值不超过100，礼物个数小于100，所有礼物总价值不超过1000
 *
 * 解法：可以转换为01背包问题
 *
 */

public class T1 {

    @Test
    public void test() {
        T1 t = new T1();
//        int[] arr = new int[]{41,467,334,1,169,224,478,358};//0
        int[] arr = new int[]{41,467,334,0,169,224,478,358,462,464,205};//4
//        int[] arr = new int[]{1,2,3,9};//3

        System.out.println(t.maxPresent(arr));
        System.out.println(t.maxPresent2(arr));
    }


    public int maxPresent (int[] presentVec) {
        if(presentVec==null || presentVec.length==0){
            return 0;
        }

        int[] arr = presentVec;
        int n= arr.length;


        int totalSum  = 0;
        for(int i = 0;i<n;i++){
            totalSum+=arr[i];
        }
        int m =(totalSum+1)/2;
        //转换为大小为m的01背包问题

        int[][] dp = new int[n+1][m+1];

        int[] w = new int[n+1];
        int[] v = new int[n+1];

        for(int i = 0;i<n;i++){
            w[i+1]=arr[i];
            v[i+1]=arr[i];
        }

        for(int i = 1;i<=n;i++){
            for(int j= m;j>0;j--){
                if(j>=w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - w[i]] + v[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
//        int maxa = P01beibao.do01(w,v,m);
        int maxa = dp[n][m];
        System.out.println("totalSum:\t"+totalSum);
        System.out.println("maxa:\t"+maxa);
        System.out.println("totalSum-maxa:\t"+(totalSum-maxa));
        System.out.println(dp.length+":"+dp[0].length);
        Utils.showArray(dp);
        return Math.abs(maxa-(totalSum-maxa));
    }

    public int maxPresent2 (int[] presentVec) {
        // write code here
        int n = presentVec.length;
        if(n == 0) return 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += presentVec[i];
        }
        //简化为背包问题
        int v = (sum + 1) / 2;
        int[] dp = new int[v+1];
        for(int i = 0; i < n; i++){
            int p = presentVec[i];
            for(int j = v; j >= p; j--){
                dp[j] = Math.max(dp[j], dp[j - p] + p);
            }
        }
        int result = 2*dp[v] - sum;
        Utils.showArray(dp);
        System.out.println();
        return  result >= 0 ? result : -result;
    }
}
