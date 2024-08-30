package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2020/2/24 16:55
 * author:WLK
 *
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：先从右向左扫描出某个nums[i] > nums[i-1],然后从i右边在扫描第一个刚大于nums[i-1]的元素j，交换nums[i-1]、nums[j],
 *  然后逆序nums[i;n-1]
 *          参考官方题解：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/
 */
public class n031 {

    @Test
    public void test() {

        n031 t = new n031();
        int[] nums = new int[]{1,5,8,4,7,6,5,3,2,1};
//        int[] nums = new int[]{1,5,1};
        t.nextPermutation(nums);
        Arrays.stream(nums).forEach(v->System.out.print(v+" "));
    }

    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int i = n-1;
        // 找i
        for(;i>0;i--){
            if(nums[i]>nums[i-1]){
                break;
            }
        }

        if(i>0){
            int j = n-1;
            while(j>=i&&nums[i-1]>=nums[j]){
                j--;
            }
            int t = nums[i-1];
            nums[i-1] = nums[j];
            nums[j] = t;
        }

        int midSize = (n-1-i)/2;
        int t;
        //TODO ，这里应该改为逆序，即
        for(int ii = 0;ii<=midSize;ii++){
            t = nums[i+ii];
            nums[i+ii]=nums[n-1-ii];
            nums[n-1-ii]=t;
        }
    }

}
