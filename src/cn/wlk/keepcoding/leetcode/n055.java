package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */

//done

/**
 * 解法：
 *      设一个dp数组，dp[i]代表从当前i位置可以到达的最远位置的下标，
 *      dp的递推式为：
 *          dp[i]=max(dp[i-1],nums[i]+i)
 *
 *          其中，需要提前判断dp[i-1]。若dp[i-1]==(i-1)，
 *          也就是i-1位置能到达的最远位置就为i-1，则说明之后的位置都不可到达，返回false
 */
public class n055 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len==0)
            return true;
        int[] dp = new int[len];//dp[i]代表了从i点可以跳到的最远距离
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if ((dp[i-1]==(i-1)))
                return false;
            dp[i] = Math.max(dp[i - 1], nums[i] + i);

        }
        if (dp[len - 1] != 0)
            return true;
        else return false;
    }

    @Test
    public void test() {
        n055 t = new n055();
        int[] nums = {2,3,1,0,4};
        System.out.println(t.canJump(nums));

        int[] nums2 = {2,3,1,1,4};
        System.out.println(t.canJump(nums2));
        int[] nums3 = {1,0};
        System.out.println(t.canJump(nums3));
        int[] nums4 = {1,1,0,1};
        System.out.println(t.canJump(nums4));
        int[] nums5 = {1,1,4,0,0,0,1};
        System.out.println(t.canJump(nums5));

        int[] nums6 = {0};
        System.out.println(t.canJump(nums6));
    }

}
