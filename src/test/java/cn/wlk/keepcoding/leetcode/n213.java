package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Map;

/**
 * 2020/2/2 18:35
 * author:WLK
 * 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法:动态规划，，分别讨论第一家抢或不抢的情况即可，，分两次规划，最后求max即可
 *
 */

public class n213 {

    @Test
    public void test() {
        n213 t = new n213();
        int[] arr = new int[]{1,2,3,1};
//        int[] arr = new int[]{2,3,2};
        System.out.println(t.rob(arr));
    }
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==0){
            return 0;
        }
        if(n==1){
            return  nums[0];
        }
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];

        dp1[1] = 0;
        dp2[1] = nums[0];

        for (int i = 2; i <=n; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i-1], dp1[i - 1]);
            if(i<n) {
                dp2[i] = Math.max(dp2[i - 2] + nums[i - 1], dp2[i - 1]);
            }
        }

        return Math.max(dp1[n],dp2[n-1]);
    }

}
