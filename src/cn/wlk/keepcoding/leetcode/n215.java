package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 215. 数组中的第K个最大元素
 */
//done
    /*
    这题目还是中等级别？？
     */
public class n215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len-k];
    }

    @Test
    public void test() {
        int arr[] ={3,2,3,1,2,4,5,5,6};
        int k = 4;
        n215 t = new n215();
        System.out.println(t.findKthLargest(arr,k));
    }

}
