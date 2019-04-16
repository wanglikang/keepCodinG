package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/16-10:06
 * author:WLK
 *
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 解法：二分法搜索
 *
 */
public class n035 {
    @Test
    public void test() {
        n035 t = new n035();
//        int[] nums = {1,3,5,6};
//        System.out.println(t.searchInsert(nums,0));
//        System.out.println(t.searchInsert(nums,1));
//        System.out.println(t.searchInsert(nums,2));
//        System.out.println(t.searchInsert(nums,3));
//        System.out.println(t.searchInsert(nums,4));
//        System.out.println(t.searchInsert(nums,5));
//        System.out.println(t.searchInsert(nums,6));
//        System.out.println(t.searchInsert(nums,7));
//        System.out.println(t.searchInsert(nums,8));
        int[] nums={1};
        System.out.println(t.searchInsert(nums,0));
        System.out.println(t.searchInsert(nums,1));
        System.out.println(t.searchInsert(nums,2));

    }

    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r = nums.length-1;
        int mid;
        while(l<=r){
            mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }

       return l;
    }


}