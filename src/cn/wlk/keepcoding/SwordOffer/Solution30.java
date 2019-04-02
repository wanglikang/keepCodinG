package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/2 11:57
 * author:WLK
 * 连续子数组的最大和
 *
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * 解法：动态规划，
 *      dp[i]为以i结尾的最大的和
 *      result是全局最大值
 *
 */
public class Solution30 {
    @Test
    public void test() {
        Solution30 t = new Solution30();
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(t.FindGreatestSumOfSubArray(arr));
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int[] dp = new int[len];//以i结尾的数组的最大和
        dp[0] = array[0];
        int result = dp[0];
        for(int i = 1;i<len;i++){
            dp[i] = Math.max(array[i],dp[i-1]+array[i]);
            result = Math.max(dp[i],result);
        }
        return result;
    }
}
