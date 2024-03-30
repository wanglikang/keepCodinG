package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1. 两数之和
 *
 *
 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 */
//done
public class n001 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result =new int[2];
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if((nums[i]+nums[j])==target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return  result;

    }
    @Test
    public void test() {
        n001 n = new n001();
        int[] nums={3,2,4};
        int result[] = n.twoSum(nums,6);
        System.out.println(result[0]+":"+result[1]);

    }

}
