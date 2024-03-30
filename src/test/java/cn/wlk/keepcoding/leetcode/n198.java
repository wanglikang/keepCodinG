package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
//done

/**
 * 解题方法：动态规划
 * 设两个数组sumnotright和sumright
 * sumnoright[i]代表考虑到第i个元素，不包含最右边元素（也就是第i个元素）的最大和
 * sumright[i]代表考虑到第i个元素，包含最右边元素（也就是第i个元素）的最大和
 * 递归表达式为：
 *  sumright[i]=max(sumnotright[i-1]+nums[i],sumright[i-1])
 *  sumnotright[i]=sumright[i-1]
 */
public class n198 {
    public int rob(int[] nums) {

        int len = nums.length;
        int sumright[] = new int[len];
        int sumnotright[]=new int[len];

        if(len==0)
            return 0;
        if(len==1)
            return nums[0];
        sumright [0] =  nums[0];
        sumnotright[0] = 0;
        for(int i = 1;i<len;i++){
            sumright[i] = Math.max(sumnotright[i-1]+nums[i], sumright[i-1]);

            sumnotright[i] = sumright[i-1];

        }
        return Math.max(sumnotright[len-1],sumright[len-1]);
    }
    @Test
    public void test() {
        n198 t = new n198();
        int num []  = {2,1,1,2};
        System.out.println(t.rob(num));
    }

}
