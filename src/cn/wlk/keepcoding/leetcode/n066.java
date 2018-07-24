package cn.wlk.keepcoding.leetcode;

import org.junit.Test;
import sun.nio.ch.Util;

/**
 * 66. 加一
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
//done
public class n066 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] nums = new int[len + 1];
        int up = 0;
        int v = 0;
        v = (digits[len - 1] + 1);
        nums[len - 1] = v % 10;
        up = v > 9 ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            v = (digits[i] + up);
            nums[i] = v % 10;
            up = v > 9 ? 1 : 0;
        }
        if (up > 0) {
            nums[0] = 1;
            return nums;
        } else {
            int[] n = new int[len];
            for (int i = 0; i < len; i++) {
                n[i] = nums[i];
            }
            return n;

        }
    }

    @Test
    public void test() {
        n066 n = new n066();
        int[][] nums = {{1, 3, 4},
                {9, 9, 9, 9},
                {0},
                {1, 0},
                {1, 0, 0, 0}};
        for (int i = 0; i < nums.length; i++) {
            int[] result = n.plusOne(nums[i]);
            Utils.showArray(result);
        }


    }

}
