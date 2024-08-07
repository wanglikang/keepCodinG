package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * 2024/7/26 20:00
 * author:nx
 */

/**
 * 解法1：
 *  使用hash表，但是不符合空间复杂度要求
 *  
 * 解法2：
 *    对于本题，有下面的结论：
 *      对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。
 *  将给定的数组本身，当作hash表
 *  1、遍历数组，将小于1的数，标记为大于N的任意数字 如N+1
 *  2、？？？想不通了
 *  暂时放弃
 */

public class n041 {

    @Test
    public void test() {
        n041 t = new n041();
    }

}
