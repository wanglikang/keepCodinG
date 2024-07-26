package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

/**
 * 简单题，遍历一遍即可
 * 解法：
 * 设一个变量记录当前的最小价格，
 * 设一个变量记录最大的利润，
 * 每次遍历一个价格的时候，比较判断当前利润和最大利润的关系，更新最大利润。并且更新最小价格
 */
public class n121 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int len = prices.length;
        int result = 0;
        int minPrice = prices[0];
        for (int i = 0; i < len; i++) {
            result = Math.max(result,prices[i]-minPrice);
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
        }
        return result;
    }
    @Test
    public void test() {
        n121 n = new n121();
        int[] t = {1,2};
        System.out.println(n.maxProfit(t));

    }

}
