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
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 *
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 *
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 */

/**
 * 解法：
 *      先排序
 *      然后遍历 每一个小于0的数字
 *      从 当前位置k的下一个位置k+1，到数组结束len-1，
 *          滑动窗口，判断是否有数字能满足相加等于nums[k] 的，若有，则表示找到了，记录
 */
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
