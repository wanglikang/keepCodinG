package cn.wlk.keepcoding.niuke.Campus2018;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019/3/24 11:19
 * author:WLK
 */

/**
 * 题目描述
 * <p>
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
 * <p>
 * 给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
 * 测试样例：
 * <p>
 * [10,22,5,75,65,80],6
 * <p>
 * 返回：87
 */
public class TXStockTradingDay {
    @Test
    public void test() {

        int[] prices = {10, 22, 5, 75, 65, 80};
        int n = 6;
        System.out.println(maxProfit(prices, n));

    }

    public int maxProfit(int[] prices, int n) {
        // write code here
        int maxPro = Integer.MIN_VALUE;
        int mid = 2;
        while (mid < n - 2) {
            maxPro = Math.max(maxPro,
                    Math.max(findMaxMoney(prices, 0, mid - 1), findMaxMoney(prices, mid, n - 1)));
            mid++;
        }

        return maxPro;
    }

    public int findMaxMoney(int[] arr, int start, int end) {
        int[] diff = new int[end-start+1];
        diff[0] = 0;
        for(int i = start+1;i<=end;i++) {
            diff[i - start] = arr[i] - arr[i - 1];
        }
        int maxSum= 0;
        for(int i = 0;i<diff.length;i++){
            maxSum = Math.max(maxSum, maxSum+diff[i]);
        }
        System.out.println(start+":"+end+":"+maxSum);
        return  maxSum;
    }
}
