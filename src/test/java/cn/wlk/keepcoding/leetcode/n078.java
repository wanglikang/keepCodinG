package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */

/**
 * 解法参见：
 * http://www.cnblogs.com/grandyang/p/4309345.html
 */
//done
public class n078 {

    public List<Integer> copyList(List<Integer> li) {
        List<Integer> result = new ArrayList<>();
        for (int i : li) {
            result.add(i);
        }
        return result;
    }


    /**
     * 解法一：使用深度优先搜索算法
     *
     * @param result 最后的结果集
     * @param currRe 当前的结果集
     * @param nums   数组
     * @param deepth 搜索的深度
     */
    public void dfs(List<List<Integer>> result, List<Integer> currRe, int[] nums, int deepth) {

        int maxdeepth = nums.length;
        if (deepth == maxdeepth) {
            List<Integer> re = copyList(currRe);
            result.add(re);
            return;
        } else {
            currRe.add(nums[deepth]);
            dfs(result, currRe, nums, deepth + 1);
            currRe.remove(currRe.size() - 1);
            dfs(result, currRe, nums, deepth + 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currRe = new ArrayList<>();
        dfs(result, currRe, nums, 0);
        return result;
    }


    /**
     * 解法二：使用二进制位运算
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        int mmax = 1 << len;
        for (int i = 0; i < mmax; i++) {
            int index = i;
            int id = 0;
            List<Integer> li = new ArrayList<>();
            while (id<len) {
                if ((index & 1) == 1) {
                    li.add(nums[id]);
                }
                id++;
                index = index >> 1;
            }
            result.add(li);
        }
        return result;
    }


    @Test
    public void test() {
        n078 t = new n078();
        int[] nums = {2, 3, 4};
        List<List<Integer>> result = t.subsets2(nums);
        Utils.showListInList(result);
        System.out.println("----------------");
    }

}
