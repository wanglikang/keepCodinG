package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/3/2 10:31
 * author:WLK
 *
 * 面试题03. 数组中重复的数字
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：若数组内无重复数组，则数组下标应该即为对应元素的值，，所以将数组元素放到“正确”的位置；若此位置上已存在“正确”的元素，则为重复的元素
 */

public class TP003 {

    @Test
    public void test() {
        TP003 t = new TP003();
        int[] nums = new int[]{3,0,1,4,4,2};
        System.out.println(t.findRepeatNumber(nums));
    }

    /**
     * 1.用set
     * 2.先排序
     * 3.把数组的index看作是索引
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {


        int n = nums.length;
        int i = 0;
        int t;
        while(i<n){
            if(nums[i]==i){
                i++;
            }else if(nums[nums[i]]==nums[i]){

                return nums[i];
            }else{
                  t = nums[nums[i]];
                  nums[nums[i]] = nums[i];
                  nums[i]=t;
            }
        }
        return -1;

    }


}
