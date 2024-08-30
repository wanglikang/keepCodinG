package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 2024/8/8 21:20
 * author:nx
 */

public class n239 {

    public int[] maxSlidingWindow(int[] nums, int k){
        // 队列中只保存当前窗口内的最大值下标
        Deque<Integer> deque = new LinkedBlockingDeque<>();
        int[] result = new int[nums.length-k+1];
        for(int i = 0;i<nums.length;i++){
            int curNum = nums[i];
            if(deque.size() == 0){
                deque.add(i);
            }else {
                //当遍历到比当前队顶元素大的元素时，就删除队中小于当前元素的下标
                while (!deque.isEmpty() && nums[deque.peekFirst()] <= curNum) {
                    deque.pollFirst();
                }
                deque.addFirst(i);
            }
            if(i - deque.peekLast() > k ) {
                deque.pollLast();
            }
            if(i >= k - 1){
                //遍历的个数大于了k，开始取队顶的下标对应的元素，作为结果
                result[i-k+1] = nums[deque.peekLast()];
            }
        }
        return result;
    }


    @Test
    public void test() {
        n239 t = new n239();
        int[] ints = t.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        Utils.showArray(ints);
    }

}
