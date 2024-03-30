package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 33. 搜索旋转排序数组
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值， ，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
//done

/**
 * 解题方法：
 *      使用二分搜索法，对不同的情况分别作出判断，
 *      对于数组：
 *          5,6,7,8,1,2,3,4
 *          分为两部分：
 *              5,6,7,8
 *            和
 *              1,2,3,4
 *           对mid和target的值所处的区间进行判断即可
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
                    l = mid+1;
                }
            } else if (nums[mid] < target) {
                if(nums[mid]>=nums[left] || target<=nums[right])
                    l=mid+1;
                else r = mid-1;
            }
        }

        if (l == r && nums[l] == target)
            return l;
        else return -1;
    }

    @Test
    public void test() {
        n033 t = new n033();
        int[] nums = {5,6};
        System.out.println(t.search(nums, 6));
        System.out.println(t.search(nums,3));
        System.out.println(t.search(nums, 5));
    }

}
