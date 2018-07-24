package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 */
//done
public class n217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length ==0)
            return false;
        Arrays.sort(nums);
        int len = nums.length;
        int lastnum = nums[0];
        for(int i= 1;i<len;i++){
            if(lastnum==nums[i])
                return true;
            else{
                lastnum =nums[i];
            }
        }
        return false;
    }
    @Test
    public void test() {

    }

}
