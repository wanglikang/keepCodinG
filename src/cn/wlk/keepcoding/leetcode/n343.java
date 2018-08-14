package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 343. 整数拆分
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
//done
public class n343 {
    public int integerBreak(int n) {
        if(n<3)
            return 1;
        if(n==3)
            return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        int maxvalue = 0;
        for(int i = 4;i<=n;i++){
            maxvalue = 0;
            int j;
            for(j= 2;j<=i/2;j++)
                maxvalue = Math.max(maxvalue,j*Math.max(dp[i-j],i-j));
            //System.out.println(i+":"+j+":"+maxvalue);
            dp[i]=maxvalue;

        }
//        for(int i = 0;i<=n;i++)
//            System.out.print(i+"\t");
//        System.out.println();
//        for(int i = 0;i<=n;i++)
//            System.out.print(dp[i]+"\t");
//        System.out.println();
        return dp[n];

    }


    @Test
    public void test() {
        n343 t = new n343();
        System.out.println(t.integerBreak(12));
    }

}
