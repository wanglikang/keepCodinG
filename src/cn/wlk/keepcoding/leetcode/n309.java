package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 309. 最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
//done

/**
 * 解法：
 *      参考：https://blog.csdn.net/weixin_37725502/article/details/80322593
 */
public class n309 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len==0||len==1)
            return 0;
        int result[] = new int[len];//result[j]表示到第j天为止的最大收益
        int[][] dp = new int[len][len];//dp[i][j]代表第i天买入，第j天卖出的收益
        for(int i = 0;i<len;i++){
            for(int j =i+1;j<len;j++){//初始化dp
                dp[i][j] = prices[j]-prices[i];
                if(dp[i][j]<0)
                    dp[i][j]=0;
            }
        }
        result[0] = dp[0][1];
        for(int j = 1;j<len;j++){

            if(j>1){//假设第j天无操作或者在冻结期
                result[j]=Math.max(result[j],result[j-1]);
            }
            if(j>2){//假设第j天买入
                result[j] = Math.max(result[j],result[j-2]);
            }

            for(int i = 0;i<j;i++){//假设在第j天卖出，则依次计算在之前的每天加入买入股票时的收益
                result[j] = Math.max(result[j],dp[i][j]);
                if(i>2){
                    result[j]  = Math.max(result[j],dp[i][j]+result[i-2]);
                }

            }
        }
        return result[len-1];
    }

    @Test
    public void test() {
        n309 t = new n309();
        int[] prices = {1,2,3,0,2};
        System.out.println(t.maxProfit(prices));
    }

}
