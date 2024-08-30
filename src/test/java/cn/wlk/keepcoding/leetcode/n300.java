package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 300. 最长上升子序列
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */

/**
 * 解法1：动态规划
 * 解法2：贪心 + 二分查找？
 *  要让序列上升的更慢，才能找到更长的递增子序列
 *  dp[i]:它的每一项 dp[i] 的含义是，所有长度为 i+1 的上升子序列的末尾元素中的最小值。(参考：https://writings.sh/post/longest-increasing-subsequence-revisited)
 *
 */
public class n300 {
    /**
     * 方法1：动态规划（两次遍历）
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1)
            return len;
        //dp[i]:从【0】 到当前元素i 的最长上升子序列长度
        int[] dp = new int[len];
        dp[0] = 1;
        int result = 0;
        result=1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
//        for (int j : dp) {
//            System.out.print(j+" ");
//        }
//        System.out.println();
        return result;
    }


    @Test
    public void test() {
        Stack<String> stack = new Stack<>();
        stack.peek();
        stack.push("x");
        stack.pop();
        Queue<String> queue = new LinkedBlockingQueue<>();
        queue.peek();//查看队列头元素
        queue.offer("x");//向队列尾添加元素
        queue.poll();//返回并移除队列头元素
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("x");//向双端队列头添加元素
        deque.offerFirst("x");//
        deque.addLast("x");//向双端队列尾添加元素
        deque.offerLast("x");
//        deque.reversed();// 反转
        deque.peekFirst();
        deque.peekLast();
        deque.pollFirst();
        deque.pollLast();
        Deque<String> dequeLink = new LinkedBlockingDeque<>();

        n300 t = new n300();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(t.lengthOfLIS(nums));
    }

}
