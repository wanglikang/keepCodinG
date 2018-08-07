package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */

//UNDONE

/**
 * 超时了
 */
public class n322 {
    public int dealWith(int[] coins, int index, int sum) {
        if (index >= coins.length)
            return 100000;

        if (sum < 0)
            return 100000;

        if (sum == 0)
            return 0;

        int result =  Math.min(
                dealWith(coins, index, sum - coins[index]) + 1,
                dealWith(coins, index + 1, sum));
//        System.out.println(result);
        return result;


    }

    public int coinChange(int[] coins, int amount) {
        int result = dealWith(coins, 0, amount);
        if (result < 100000)
            return result;
        else return -1;
    }

    @Test
    public void test() {
        n322 t = new n322();
        int[] coins = {470,35,120,81,121};

        System.out.println(t.coinChange(coins, 9825));
        System.out.println();
    }

}
