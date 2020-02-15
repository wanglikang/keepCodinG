package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 15. 三数之和
 * <p>
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
//done
public class n015 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result= new ArrayList<>();
        for (int k = 0; k < len; k++) {
            if (nums[k] > 0)
                break;
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            int target = 0-nums[k];
            int i = k + 1, j = len - 1;
            while(i<j){
                if(nums[i]+nums[j]==target){
                    List<Integer> re=  new ArrayList<>();
                    re.add(nums[k]);
                    re.add(nums[i]);
                    re.add(nums[j]);
                    result.add(re);
                    while(i<j&&nums[i]==nums[i+1])i++;
                    while(i<j&&nums[j]==nums[j-1])j--;
                    i++;
                    j--;
                }else if(nums[i]+nums[j]>target)j--;
                else i++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        n015 t = new n015();
        int[] nums = {0};

        List<List<Integer>> result = t.threeSum(nums);
        for(List<Integer> li:result){
            for(int i :li){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

}
