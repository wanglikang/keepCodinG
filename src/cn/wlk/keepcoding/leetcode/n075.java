package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */

/**
 * done
 * 解法：
 *      先考虑能不能做出来
 *      在考虑优化、性能的问题
 *      否则，会秃头
 */
public class n075 {
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void moveL2R(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, l + 1);
            l++;
        }
    }

    public void moveR2L(int[] nums, int l, int r) {
        while (r > l) {
            swap(nums, r - 1, r);
            r--;
        }
    }

    public void sortColors(int[] nums) {
        int l0 = -1;
        int l1 = -1;
        int l2 = nums.length - 1;
        int len = nums.length;
        for(int k = 0;k<len;k++){
            if(nums[k]==0){
                l0++;
                l1++;
            }else if(nums[k]==1){
                l1++;

            }else if(nums[k]==2){
                l2--;
            }
        }
        for(int i  = 0;i<=l0;i++){
            nums[i]=0;
        }
        for(int i = l0+1;i<=l1;i++)
            nums[i]=1;
        for(int i = l1+1;i<len;i++)
            nums[i]=2;
    }

    @Test
    public void test() {
        n075 t = new n075();
        int[] nums = {2, 2, 0, 2, 0, 2, 2, 0, 0, 0, 1, 2};
        t.sortColors(nums);
        Utils.showArray(nums);
        System.out.println();
    }

}
