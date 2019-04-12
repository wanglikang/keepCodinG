package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2019/4/12-9:15
 * author:WLK
 *
 * 169. 求众数
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 解法：排序求中位数即可
 */
public class n169 {
    @Test
    public void test() {
        n169 t = new n169();
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len/2];
    }

}