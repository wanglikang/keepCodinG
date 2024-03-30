package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 2019/7/4 10:08
 * author:WLK
 * <p>
 * 128. 最长连续序列
 * <p>
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class n128 {
    @Test
    public void test() {
        n128 t = new n128();
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {1, 2, 0, 1};
//        int[] nums = {1, 2, 3, 4, 5};
        int re = t.longestConsecutive(nums);
        System.out.println(re);
    }

    /**
     * 使用空间换时间，用map保存区间之间的长度，
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxResult = 0;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                int left = map.getOrDefault(nums[i] - 1, 0);
                int right = map.getOrDefault(nums[i] + 1, 0);
                int re = left + right + 1;
                map.put(nums[i], re);
                map.put(nums[i] - left, re);
                map.put(nums[i] + right, re);

                System.out.println(nums[i]+":"+re);
                maxResult = Math.max(maxResult, re);
            }
        }
        return maxResult;

    }

    /**
     * 先排序，在统计，n(nlogn),不符合要求
     *
     * @param nums
     * @return
     */
    public int longestConsecutive_1(int[] nums) {
        Arrays.sort(nums);
        int maxResult = 1;
        int currResult = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                currResult++;
            } else {
                currResult = 1;
            }
            maxResult = Math.max(maxResult, currResult);

        }
        return maxResult;

    }


}
