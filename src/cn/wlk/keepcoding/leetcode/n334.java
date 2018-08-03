package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 334. 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
//done
public class n334 {
    /**
     * 解法参考：
     * https://www.cnblogs.com/grandyang/p/5194599.html
     *  此解法满足O(1)的空间复杂度
     *  神奇的解法
     * @param nums
     * @return
     */

    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        /**
         * m1的作用是设定一个锚点，此锚点以前的数中必定有一个数小于此锚点
         * m1的作用也是设定一个锚点，此锚点以后的数中必定有一个数大于此锚点
         *
         * 于是，只要满足有一个数在吗m1和m2之间，即可满足题意
         */
        for (int a =0;a<len;a++){
            if (m1 >= nums[a]) m1 = nums[a];
            else if (m2 >= nums[a]) m2 = nums[a];
            else return true;
        }
        return false;
    }

    @Test
    public void test() {
        n334 t = new n334();
        int[] nums= {5,1,4,3,2,4};
        System.out.println(t.increasingTriplet(nums));
    }

}
