package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 2020/2/17 13:49
 * author:WLK
 *
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 解法：使用回溯方法，注意在每一层的时候加一个去重的set即可
 */

public class n047 {

    @Test
    public void test() {
        n047 t = new n047();
//        int[] nums = new int[]{1,1,2,3,4};
        int[] nums = new int[]{1,1,2};
        t.permuteUnique(nums).stream().forEach(v->{
            v.forEach(vv->{
                System.out.print(vv+" ");
            });

            System.out.println();
        });
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack  = new Stack<>();
        Set<Integer> set = new HashSet<>();
        dfs(nums,0,set,result,stack);

        return result;
    }


    public void dfs(int[] nums, int depth,Set<Integer> pathSet, List<List<Integer>> globalResult, Stack<Integer> path){
        int n = nums.length;
        if (depth == n) {
            globalResult.add(new ArrayList<>(path));
        }
        Set<Integer> localSet = new HashSet<>();
        for(int i = 0;i<n;i++) {
            if( !pathSet.contains(i)) {
                if(!localSet.contains(nums[i])) {
                    localSet.add(nums[i]);

                    path.push(nums[i]);
                    pathSet.add(i);
                    dfs(nums, depth + 1, pathSet, globalResult, path);
                    pathSet.remove(i);
                    path.pop();
                }
            }
        }
    }

}
