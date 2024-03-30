package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
//done

/**
 * 解法：
 *      先使用二分法求出一个target所在的位置下标，然后像两边扩展即可
 */
public class n034 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int len = nums.length;

        int tl = 0;
        int tr = r;
        int targetindex = tl + (tr - tl) / 2;
        int[] result = new int[2];

        while (tl < tr) {
            targetindex = tl + (tr - tl) / 2;
//            System.out.println(tl + ":" + tr);
            if (nums[targetindex] == target)
                break;
            if (nums[targetindex] < target) {
                tl = targetindex + 1;
            } else if (nums[targetindex] > target) {
                tr = targetindex - 1;
            }

        }
//        System.out.println(tl + ":" + tr);
        if (tl == tr && nums[tl] == target) {
            result[0] = tl;
            result[1] = tl;

        } else if (tl >= tr) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int i;
        for (i = targetindex; i >= 0; i--) {
            if (nums[i] < target)
                break;
        }
        result[0] = i + 1;
        int j;
        for (j = targetindex; j < len; j++) {
            if (nums[j] > target)
                break;
        }
        result[1] = j - 1;
        return result;
    }

    @Test
    public void test() {
        n034 t = new n034();
        int[] nums = {
                1, 1, 1, 2, 2, 2, 2, 3, 3, 3,
                3, 4, 4, 5, 5, 5, 5, 5, 5, 5,
                6, 6, 6};
        int[] result = t.searchRange(nums, 1);
//        System.out.println("---------------");
        System.out.println(result[0] + ":" + result[1]);
        System.out.println();
    }

}
