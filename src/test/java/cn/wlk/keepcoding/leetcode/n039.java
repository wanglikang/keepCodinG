package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2020/2/16 13:34
 * author:WLK
 *
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 *     所有数字（包括 target）都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 解法：递归解法，
 *  递归f(nums，i,target):
 *      求解以下标i开始的nums数组中target为目标和的所有解集，然后将nums[i]加入到解集中
 */

public class n039 {

    @Test
    public void test() {
        int[] nums = new int[]{2,3,6,7};
        int target = 1;
        n039 t = new n039();
        List<List<Integer>> result = t.combinationSum(nums, target);
        result.forEach(v->{
            v.forEach(vv->{
                System.out.print(vv+" ");
            });
            System.out.println();
        });
    }

    public List<List<Integer>> func(int[] nums,int i ,int target){
        List<List<Integer>> result  = new ArrayList<>();
        int n = nums.length;
        if(i>=n){
            return result;
        }
        if(nums[i]>target){
            return result;
        }

        if(nums[i]==target){
            result.add(new ArrayList<>(Arrays.asList(nums[i])));
            return result;
        }
        //nums[i] < target

        for(int j = i;j<n;j++) {
            List<List<Integer>> subresult = func(nums, j, target - nums[i]);
            if (subresult.size() > 0) {
                List<List<Integer>> subr = subresult.stream().map(v -> {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.addAll(v);
                    return r;
                }).collect(Collectors.toList());
                result.addAll(subr);
            }
        }
        return result;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result    = new ArrayList<>();
        Arrays.sort(candidates);
        for(int i = 0;i<candidates.length;i++) {
            List<List<Integer>> subre = func(candidates, i, target);
            result.addAll(subre);

        }
        return result;
    }

}
