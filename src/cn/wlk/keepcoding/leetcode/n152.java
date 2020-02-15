package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/2/2 18:22
 * author:WLK
 *
 * 152. 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：因为负负得正，所以需要设一个当前最大值，和当前最小值。
 *      然后
 *          maxDP[i + 1] = max(maxDP[i] * A[i + 1], A[i + 1],minDP[i] * A[i + 1])
 *          minDP[i + 1] = min(minDP[i] * A[i + 1], A[i + 1],maxDP[i] * A[i + 1])
 *          dp[i + 1] = max(dp[i], maxDP[i + 1])
 *
 */

public class n152 {

    @Test
    public void test() {
        n152 t = new n152();
//         int[] in = new int[]{2,3,-2,4};
//        int[] in = new int[]{-1,0,1};
        int[] in = new int[]{-2,3,4,-10,-10};
        System.out.println(t.maxProduct(in));
    }


    //参考：https://leetcode-cn.com/problems/maximum-product-subarray/solution/dpfang-fa-xiang-jie-by-yang-cong-12/
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        } else if(n == 1) {
            return nums[0];
        }

        int p= nums[0];
        int max = nums[0];
        int min = nums[0];
        int t=0;
        for(int i = 1;i<n;i++){
            t = max;
            max = Math.max(Math.max(max* nums[i],nums[i]),min*nums[i]);
            min = Math.min(Math.min(t*nums[i],nums[i]),min*nums[i]);
            p = Math.max(max,p);
        }
        return p;

    }

    //网上的解法
    public int maxProduct_other(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

}
