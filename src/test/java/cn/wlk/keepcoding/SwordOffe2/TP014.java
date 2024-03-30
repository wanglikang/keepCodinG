package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/3/2 18:20
 * author:WLK
 *
 * 面试题14- I. 剪绳子
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 提示：
 *
 *     2 <= n <= 58
 *
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 * 解法：动态规划,需要对n=3,n=4特殊处理
 */

public class TP014 {

    @Test
    public void test() {
        TP014 t = new TP014();
        for(int i = 2;i<200;i++) {
            System.out.println(i+"\t"+t.cuttingRope(i)+"\t");
        }
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        if(n==3){
            return 2;
        }
        if(n==4){
            return 4;
        }

        for(int i = 3;i<=n;i++){
            dp[i]=Math.max(2*dp[i-2],3*dp[i-3]);
        }

        return dp[n];

    }



}
