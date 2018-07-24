package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j),
 * 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2:
 * <p>
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3:
 * <p>
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * 注意:
 * <p>
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 */
public class n532 {
    public int findPairs(int[] nums, int k) {
        int result = 0;
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        Set<Integer> reset = new HashSet<>();
        //在k=0的情况下，也就是数组中有重复的数字的个数，例如
        /**
         * 输入:
         * [1,1,1,2,2,2]
         * 0
         * 应输出：
         * 2
         * 也就是对：1-1,2-2,扯淡的情况
         */


        for (int i = 0; i < len; i++) {

            if (set.contains(nums[i])) {
                reset.add(nums[i]);
            } else set.add(nums[i]);
        }
        int len2 = set.size();
        if (k == 0) {
            return reset.size();
        }
        Iterator<Integer> iterable = set.iterator();
        int[] newnuums = new int[len2];
        int count = 0;
        while (iterable.hasNext()) {
            newnuums[count++] = iterable.next();
        }


        Arrays.sort(newnuums);

        for (int i = 0; i < len2; i++) {
            for (int j = i + 1; j < len2; j++) {
                if (Math.abs(newnuums[i] - newnuums[j]) < k) {
                    ;
                } else if (Math.abs(newnuums[i] - newnuums[j]) == k) {
                    result++;
                } else break;

            }
        }


        return result;
    }

    @Test
    public void test() {
        n532 n = new n532();
        int[] nums = {3, 1, 4, 1, 5};
        System.out.println(n.findPairs(nums, 2));
    }

}
