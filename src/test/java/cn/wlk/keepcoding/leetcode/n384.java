package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 384. 打乱数组
 * 打乱一个没有重复元素的数组。
 * <p>
 * 示例:
 * <p>
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * <p>
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * <p>
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
//又是一个智障题目
public class n384 {
    class Solution {
        int[] oldnums;
        int len;

        public Solution(int[] nums) {

            len = nums.length;
            oldnums = Arrays.copyOf(nums, len);

        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return oldnums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle2() {

            int[] result = new int[len];
            Random random = new Random(System.currentTimeMillis());
            int tmpindex;
            int isuserd[] = new int[len];
            int index = 0;
            while (!isAllUsed(isuserd, len)) {
                tmpindex = random.nextInt(len);
                if (isuserd[tmpindex] == 0) {
                    isuserd[tmpindex] = 1;
                    result[index++] = oldnums[tmpindex];
                }
            }
            return result;

        }

        public int[] shuffle(){
            int[] result = Arrays.copyOf(oldnums,len);
            Random randon = new Random(System.currentTimeMillis());
            int t;
            int index ;
            for(int i = len-1;i>0;i--){
                index = randon.nextInt(i);
                t = result[index];
                result[index]  = result[i];
                result[i] = t;
            }
            return result;

        }
        public boolean isAllUsed(int[] isuserd, int len) {
            for (int i = 0; i < len; i++) {
                if (isuserd[i] == 0)
                    return false;
            }
            return true;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    @Test
    public void test() {
        n384 t = new n384();
        int [] nums = {1,2,3};
        n384.Solution s =new  n384.Solution(nums);
        Utils.showArray(s.shuffle());
        Utils.showArray(s.reset());
        Utils.showArray(s.shuffle());
        System.out.println();
    }

}
