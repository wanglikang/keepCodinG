package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2020/2/16 23:12
 * author:WLK
 *
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 *     所有数字（包括目标数）都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：同n039,递归解法，
 *          在递归前需要对当前的候选集用set去重集合
 *
 */

public class n040 {

    @Test
    public void test() {
        n040 t = new n040();

//        int[] nums  = new int[]{2,5,2,1,2};
//        int target  =5;
        int[] nums  = new int[]{10,1,2,7,6,1,5};
        int target  =8;
        List<List<Integer>> result = t.combinationSum2(nums, target);
        result.forEach(v->{
            v.forEach(vv->{
                System.out.print(vv+" ");
            });
            System.out.println();
        });
    }

    public List<List<Integer>> func(int[] nums, int i , int target){
//        System.out.println("start func"+i+":"+nums[i]);
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


        HashSet<Integer> s = new HashSet<>();
//        s.add(nums[i]);
        for(int j = i+1;j<n;j++) {
            if (!s.contains(nums[j])) {
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
                s.add(nums[j]);
            }
        }
        return result;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result    = new ArrayList<>();
        Arrays.sort(candidates);
        HashSet<Integer> s = new HashSet<>();
        for(int i = 0;i<candidates.length;i++) {
            if(!s.contains(candidates[i])) {
                List<List<Integer>> subre = func(candidates, i, target);
                result.addAll(subre);
                s.add(candidates[i]);
            }


        }
        return result;
    }

}
