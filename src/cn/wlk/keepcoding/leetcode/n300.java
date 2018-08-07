package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 300. 最长上升子序列
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
//done
public class n300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1)
            return len;
        int[] dp = new int[len];
        dp[0] = 1;
        int result = 0;
        result=1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
//        for (int j : dp) {
//            System.out.print(j+" ");
//        }
//        System.out.println();
        return result;


    }

    @Test
    public void test() {
        n300 t = new n300();
        int[] nums = {2,2};
        System.out.println(t.lengthOfLIS(nums));
    }

}
