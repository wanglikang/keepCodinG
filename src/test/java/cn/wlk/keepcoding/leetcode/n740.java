package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * 740. 删除与获得点数
 * 给定一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 4, 2]
 * 输出: 6
 * 解释:
 * 删除 4 来获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
 * 示例 2:
 *
 * 输入: nums = [2, 2, 3, 3, 3, 4]
 * 输出: 9
 * 解释:
 * 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * 注意:
 *
 * nums的长度最大为20000。
 * 每个整数nums[i]的大小都在[1, 10000]范围内。
 */
//done

/**
 * 解法：
 *      参考：https://blog.csdn.net/qq_26410101/article/details/80896585
 */
public class n740 {
    public int deleteAndEarn(int[] nums) {
        int [] dp = new int[10001];
        int[] notdp = new int[10001];
        for(int i = 0;i<nums.length;i++){
            dp[nums[i]] +=nums[i];
        }
//        Utils.showArray(dp);
        notdp[0] =0;
        notdp[1] = 0;
        notdp[2] = dp[1];

        for(int i = 1;i<10001;i++){
            dp[i]=Math.max(notdp[i-1]+dp[i],dp[i-1]);
            notdp[i]=dp[i-1];
        }

//        Utils.showArray(dp);
//        Utils.showArray(notdp);
        return Math.max(dp[10000],notdp[10000]);
    }
    @Test
    public void test() {
        n740 t = new n740();
        int[] nums = {1,1,1,2,4,5,5,5,6};
        System.out.println(t.deleteAndEarn(nums));
        System.out.println();
    }

}
