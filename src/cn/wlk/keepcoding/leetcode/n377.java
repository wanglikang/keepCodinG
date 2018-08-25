package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * 377. 组合总和 Ⅳ
 *
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 * 进阶：
 * 如果给定的数组中含有负数会怎么样？
 * 问题会产生什么变化？
 * 我们需要在题目中添加什么限制来允许负数的出现？
 *
 * 致谢：
 * 特别感谢 @pbrother 添加此问题并创建所有测试用例。
 */
//done

/**
 * 解法：
 *      深度优先搜索+dp保存结果加速
 */
public class n377 {
    public int combinationSum43(int[] nums, int target) {
        long[] dp = new long[target];
        for(int i = 0;i<target;i++)
            dp[i]=-1;
        dp[0]=1;
        int len = nums.length;
        int sum = 0;
        for(int i = 0;i<len;i++){
            sum+=getdp3(nums,dp,nums[i])*getdp3(nums,dp,target-nums[i]);

        }
        return sum;

    }

    public long getdp3(int[] nums,long[] dp,int num){

        if(dp[num]!=-1) {
//            System.out.println(num+":"+dp[num]);
            return dp[num];
        }
        if(num<0)
            return 0;
        int result  =0;
        for(int i = 0;i<nums.length;i++){
            if(num>nums[i])
                result+=getdp3(nums,dp,nums[i])*getdp3(nums,dp,num-nums[i]);
            else if(num==nums[i])
                result++;
        }
        dp[num]=result;
       // System.out.println(num+":"+dp[num]+":first");
        return result;
    }



    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int [] dp = new int[target+1];
        for(int i = 0;i<=target;i++)
            dp[i]=-1;
        return dfs(nums,dp,target);
    }

    public int dfs(int[] nums,int[] dp,int target){
        int len = nums.length;

        if(target<0)
            return 0;
        if(target==0)
            return 1;

        if(dp[target]!=-1)
            return dp[target];

        int sumCount = 0;
        for(int i =0;i<len;i++){
            if(nums[i]<=target){
                sumCount+=dfs(nums,dp,target-nums[i]);
            }
        }
//        System.out.println(target+":"+sumCount);
        dp[target]=sumCount;
        return sumCount;
    }

    @Test
    public void test() {
        n377 t = new n377();
        int[] nums = {1,2,3};
        System.out.println(t.combinationSum4(nums,32));
    }
}
