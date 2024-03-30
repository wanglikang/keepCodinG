package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2019/4/12-10:34
 * author:WLK
 *
 * 16. 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 解法：排序，遍历：双指针累加判断
 *
 */
public class n016 {
    @Test
    public void test() {
        n016 t = new n016();
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closedSum = nums[0]+nums[1]+nums[2];

        int tmpSum = 0;
        for(int i = 0;i<nums.length-2;i++){
            int l = i+1,r = nums.length-1;
            while(l<r){
                tmpSum = nums[i]+nums[l]+nums[r];
                if(Math.abs(target-tmpSum)<Math.abs(target-closedSum)){
                    closedSum = tmpSum;
                }
                if(tmpSum>target){
                    r--;
                }else if(tmpSum<target){
                    l++;
                }else return target;

            }
        }
        return closedSum;
    }



}