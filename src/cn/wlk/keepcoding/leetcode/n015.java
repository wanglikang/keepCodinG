package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15. 三数之和
 *
 *
 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class n015 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len  = nums.length;
        int remain  = 0;
        int[] isUsed = new int[len];

        for(int i = 0;i<len;i++){
            remain = 0-nums[0];
            isUsed[i] = 1;
            for(int j = 0;j<len;j++){
                if(isUsed[j]!=1){
                    isUsed[j] = 1;
                    remain = remain-nums[j];
                    for(int k = 0;k<len;k++){
                        if(isUsed[k]!=1){
                            if(nums[k]==remain){//找到了一个

                            }
                            isUsed[k]=0;
                        }
                    }
                    isUsed[j]=0;
                }
            }
            isUsed[i] = 0;
        }
        return null;

    }

    @Test
    public void test() {

    }

}
