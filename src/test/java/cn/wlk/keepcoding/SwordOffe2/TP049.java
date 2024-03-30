package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/3/5 22:52
 * author:WLK
 *
 * 面试题49. 丑数
 *
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:
 *
 *     1 是丑数。
 *     n 不超过1690。
 *
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * 解法：分别定义p2,p3,p5三个指针，指向对应的index
 */

public class TP049 {

    @Test
    public void test() {
        TP049 t = new TP049();
        System.out.println(t.nthUglyNumber(10));
    }


    public int nthUglyNumber(int n) {
        int[] dp = new int[n+2];
        dp[0]=0;
        dp[1]=1;

        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for(int i = 2;i<=n;i++){
            dp[i]=Math.min(Math.min(dp[p2]*2,dp[p3]*3),dp[p5]*5);
            if(dp[i]==dp[p2]*2){
                p2++;
            }
            if(dp[i]==dp[p3]*3){
                p3++;
            }
            if(dp[i]==dp[p5]*5){
                p5++;
            }
            System.out.println(dp[i]);

        }

        return dp[n];

    }


}
