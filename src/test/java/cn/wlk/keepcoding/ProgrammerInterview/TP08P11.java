package cn.wlk.keepcoding.ProgrammerInterview;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

/**
 * 2020/4/23 11:02
 * author:WLK
 *
 *
 * 面试题 08.11. 硬币
 *
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 *
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 *
 * 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 *     0 <= n (总金额) <= 1000000
 */

public class TP08P11 {

    @Test
    public void test() {
        TP08P11 t = new TP08P11();
//        for(int i = 0;i<10000;i++){
//            System.out.println(i+":"+t.waysToChange(i));
//        }

        System.out.println(t.waysToChange(31));
    }
    public int waysToChange(int n) {
        int MOD = 1000000007;
        int[] dp = new int[n + 1];


        dp[0] = 1;
        int[] tarr = new int[]{1, 5, 10, 25};
        for(int i = 0;i<=n;i++){
            System.out.print(String.format("%3d ",i));
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            int coin = tarr[i];
            for (int j = coin; j <= n; j++) {
                    dp[j] =( dp[j] + dp[j - coin])%MOD;

            }
            Utils.showArray(dp);
            System.out.println();
        }


        return dp[n];
    }
}
