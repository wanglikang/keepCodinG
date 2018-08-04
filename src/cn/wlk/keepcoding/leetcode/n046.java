package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
//done

/**
 * 解法：
 *      还是使用递归进行全排列的打印
 */
public class n046 {
    public void swap(List<Integer> nums, int l, int r) {
        int t = nums.get(l);
        nums.set(l, nums.get(r));
        nums.set(r, t);
    }

    public void dfs(List<List<Integer>> result, List<Integer> nums, int begin) {
        int n = nums.size();
        if (begin == n) {
            result.add(nums);
        } else {
            for (int i = begin; i < n; i++) {
                List<Integer> r = new ArrayList<>(nums);
                swap(r, begin, i);
                dfs(result, r, begin + 1);
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  result= new ArrayList<>();
        if(nums.length==0)
            return result;

        List<Integer> re = new ArrayList<>();
        for(int i :nums){
            re.add(i);
        }
        dfs(result,re,0);
        return result;

    }

    @Test
    public void test() {
        n046 t = new n046();
        int[] nums = {2,3,4,5,6,7};
        List<List<Integer>> result = t.permute(nums);
        for(List<Integer> li:result){
            for(int i :li){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
