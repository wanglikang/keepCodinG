package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 283. 移动零
 * <p>
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
//done
public class n283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int notZeroIndex = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[notZeroIndex] = nums[i];
                notZeroIndex++;
            }
        }
        for(int i = notZeroIndex;i<len;i++){
            nums[i] = 0;
        }
    }

    @Test
    public void test() {
        n283 n = new n283();
        int[] nums = {1,0,2,0,3,0,4,5,6,0,0,0,7,8,0};
        n.moveZeroes(nums);
        Utils.showArray(nums);
    }

}
