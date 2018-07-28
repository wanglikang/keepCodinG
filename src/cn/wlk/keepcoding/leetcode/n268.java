package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 268. 缺失数字
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 */
//done
public class n268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int[] arr  = new int[len+1];
        for(int i = 0;i<len;i++){
            arr[nums[i]]=1;
        }
        for(int i = 0;i<len+1;i++){
            if(arr[i]==0)
                return i;
        }
        return 0;
    }
    @Test
    public void test() {
        n268 t = new n268();
        int [] nums = {9,6,4,2,3,5,7,0,1};
        int[] nums2={0,1,2,4};
        System.out.println(t.missingNumber(nums));
        System.out.println(t.missingNumber(nums2));
    }

}
