package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
//done

/**
 * 详见kadane算法.md
 */
public class n053 {
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];

        return maxSum(0, len - 1, nums);

    }

    public int maxSum(int start, int end, int[] nums) {

        if (start == end) {
            //    if (nums[start] > 0)
            return nums[start];
            // else return 0;

        }


        int leftSum, rightSum;
        int leftboardsum = 0, rightboardsum = 0;
        int maxleftboardsum = 0, maxrightboardsum = 0;
        int mid = start + (end - start) / 2;
        int maxResult = nums[0];

        leftSum = maxSum(start, mid, nums);
        rightSum = maxSum(mid + 1, end, nums);

        for (int i = mid; i >= start; i--) {
            leftboardsum += nums[i];
            maxleftboardsum = Math.max(maxleftboardsum, leftboardsum);
        }

        for (int i = mid + 1; i <= end; i++) {
            rightboardsum += nums[i];
            maxrightboardsum = Math.max(maxrightboardsum, rightboardsum);
        }
        maxResult = Math.max(Math.max(maxleftboardsum + maxrightboardsum, leftSum), rightSum);
        return maxResult;
    }


    public static int maxSubSumRec(int[] array, int left, int right) {
        //递归的基准情况:待处理序列只有一个元素
        if (left == right) {
            //空集也算是子序列，空集和为0，所以最大子序列和最小为0
            if (array[left] > 0)
                return array[left];
            else
                return 0;
        }

        //递归求出左半部分和右半部分的最大子序列和
        int center = (left + right) / 2;
        int maxLeftSum = maxSubSumRec(array, left, center);
        int maxRightSum = maxSubSumRec(array, center + 1, right);

        //求出左半部分中包含最右边元素的子序列的最大和
        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += array[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        //求出右半部分中包含最左边元素的子序列的最大和
        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += array[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        //跨越两个部分的最大子序列和
        int maxLeftRightSum = maxLeftBorderSum + maxRightBorderSum;

        //maxLeftSum、maxRightSum、maxLeftRightSum中的最大值即为最大子序列和
        int maxSubSum = 0;
        maxSubSum = maxLeftSum > maxRightSum ? maxLeftSum : maxRightSum;
        maxSubSum = maxSubSum > maxLeftRightSum ? maxSubSum : maxLeftRightSum;

        return maxSubSum;
    }

    public int mmax(int[] nums) {

        int len = nums.length;
        int maxSum = nums[0];
        int theSum = nums[0];
        int it = 0;

        for (it = it + 1; it != len; it++){
            theSum = Math.max(theSum + nums[it], nums[it]);

            if (theSum > maxSum)
                maxSum = theSum;
        }

        return maxSum;
    }


    /**
     * 这个算法很神奇
     * 参见这个解法：https://blog.csdn.net/baimafujinji/article/details/78238497
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int len = nums.length;
        int maxSum = nums[0];
        int theSum = nums[0];
        int it = 0;

        for (it = it + 1; it != len; it++){
            //即，最大连续数组和的值，要么来自前面的累计，要么来自从本元素开始
            theSum = Math.max(theSum + nums[it], nums[it]);

            if (theSum > maxSum)
                maxSum = theSum;
        }

        return maxSum;
    }

    @Test
    public void test() {
        n053 t = new n053();

        int[] nums = {-2, -1};
        //System.out.println(t.maxSubSumRec(nums,0,1  ));
        System.out.println(t.mmax(nums));

    }

}
