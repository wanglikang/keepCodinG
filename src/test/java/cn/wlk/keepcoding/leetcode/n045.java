package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/4/20 13:30
 * author:WLK
 *
 * 45. 跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 解法：和1326一个思路
 *
 */

public class n045 {

    @Test
    public void test() {
        n045 t = new n045();
        int[] arr = new int[]{2,3,1,1,4};//2
        System.out.println(t.jump(arr));
    }

    public int jump(int[] nums) {

        int n = nums.length;
        int[] pre = new int[n];
        for(int i = 0;i<n;i++){
            pre[i]=i;
        }
        int[] dp = new int[n];
        for(int i = 0;i<n;i++){
            int r =  Math.min(i+nums[i],n-1);
            pre[r]=Math.min(pre[r], i);
            //pre[j]=i :区间[i,j]

            dp[i]=Integer.MAX_VALUE;
        }

        dp[0]=0;
        for(int i = 1;i<n;i++){
            for(int j = pre[i];j<i;j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
//                    System.out.println(i+":"+dp[i]);
                }
            }
        }

        Utils.showArray(pre);
        System.out.println();
        Utils.showArray(dp);
        System.out.println();
        return dp[n-1];

    }

}
