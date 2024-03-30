package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
//done

/**
 * 解法：
 *      动态规划，dp[i]表示正整数i使用完全平方数组成所需要的最小个数，若i就是一个完全平方数，则dp[i]=1
 */
public class n279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 0;i<=n;i++)
            dp[i]=-1;
        return count(n,dp);
    }

    /**
     * 计算使等于n的最小的个数
     * @param n
     * @return
     */
    public int count(int n,int[] dp){
        if(dp[n]!=-1)
            return dp[n];
        if(n==getSqrt(n)) {
            dp[n]=1;
            return 1;
        }
        int tmpn ;
        int result = n;
        for(tmpn=getSqrt(n);tmpn>1;) {
            result =Math.min(result,count(n-tmpn,dp)+1);
            tmpn =getSqrt(tmpn-1);
        }
        dp[n]=result;
        return result;
    }

    public int getSqrt(int n){
        int m =  (int)Math.sqrt(n*1.);
        return m*m;
    }

    @Test
    public void test() {
        n279 t = new n279();
        System.out.println(t.numSquares(11));
        System.out.println(t.numSquares(12));
        System.out.println(t.numSquares(13));
        System.out.println(t.numSquares(14));
        System.out.println();
    }

}
