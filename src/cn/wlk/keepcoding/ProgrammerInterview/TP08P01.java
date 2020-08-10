package cn.wlk.keepcoding.ProgrammerInterview;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

/**
 * 2020/4/21 19:10
 * author:WLK
 */

public class TP08P01 {

    @Test
    public void test() {
        TP08P01 t = new TP08P01();
        t.waysToStep(61);
    }
    int MOD = 1000000007;
    public int waysToStep(int n) {
        if(n<3){
            return n;
        }
        int[] dp  = new int[n+1];
        dp[0] = 0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i = 4;i<=n;i++){
            dp[i]=((dp[i-3]%MOD+dp[i-2]%MOD)%MOD+dp[i-1]%MOD)%MOD;
        }

        Utils.showArray(dp);
        return dp[n];

    }

}
