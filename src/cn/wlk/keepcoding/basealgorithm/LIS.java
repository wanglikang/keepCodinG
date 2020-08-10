package cn.wlk.keepcoding.basealgorithm;

import org.junit.Test;

/**
 * 2020/4/22 10:36
 * author:WLK
 *
 * 最长上升子序列
 * O(n^2)
 */

public class LIS {

    @Test
    public void test() {
        LIS t = new LIS();
    }

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

    /**
     * 另一种方式，dp[i]存的是长度为i+1的最长子序列的最后 一位数字的最小值，这样可以通过二分查找的形式，加快速度
     *          dp也为单调递增的，
     *          且dp的内容即为最长上升子数组的内容
     * @param nums
     * @return
     */
    public int lengthOfLISBest(int[] nums){

        return -1;
    }

}
