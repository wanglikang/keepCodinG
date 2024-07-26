package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 *
 *
 * 中等题
 * 解题方法：
 *      使用二分搜索法，对不同的情况分别作出判断，
 *      对于数组：
 *          5,6,7,8,1,2,3,4
 *          分为两部分：
 *              5,6,7,8
 *            和
 *              1,2,3,4
 *           对mid和target的值所处的区间进行判断即可
 *           以nums[mid] 和target 的大小关系，进行判断
 */
public class n033 {
    public int search(int[] nums, int target) {

        final int left = 0;
        final int right = nums.length - 1;
        int l = left;
        int r = right;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target) {
                if (target >= nums[left] || nums[mid] <= nums[right]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < target) {
                if(nums[mid]>=nums[left] || target<=nums[right])
                    l = mid + 1;
                else r = mid - 1;
            }
        }

        if (l == r && nums[l] == target)
            return l;
        else return -1;
    }



    @Test
    public void test() {
        n033 t = new n033();
        int[] nums = {4,5,6,8,9,10,1,2,3};
        System.out.println(t.search(nums, 6));
        System.out.println(t.search(nums,3));
        System.out.println(t.search(nums, 5));
        System.out.println(t.search(nums, 7));
        System.out.println(t.search(nums, 10));
        System.out.println(t.search(nums, 1));
    }

}
