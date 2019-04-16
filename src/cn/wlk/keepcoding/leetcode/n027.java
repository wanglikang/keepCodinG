package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/16-9:45
 * author:WLK
 *
 * 27. 移除元素
 *
 *  给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 解法：先遍历一遍，统计有多少个val即得出返回结果；再在原数组上进行赋值即可，两次操作复杂度为O(n)
 *
 */
public class n027 {
    @Test
    public void test() {
        n027 t = new n027();
        int[] nums  = {2,2};
        System.out.println("before len :"+nums.length);
        int len = t.removeElement(nums, 2);
        System.out.println("after len:"+len);
        for(int i = 0;i<len;i++){
            System.out.print(nums[i]+ " ");
        }

    }

    /**
     *     2
     *     2 3 4 2 3 4  4  3 3 2 3 3 4 54   3 3 3 323 3
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int countV = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==val){
                countV++;
            }
        }
        int result = nums.length-countV;
        int last = 0;
        int fillindex = 0;
        int currindex = 0;
        while(currindex<nums.length){

            if(nums[currindex]!=val) {//填充
//                fillindex = currindex;
                nums[fillindex]=nums[currindex];
                fillindex++;
                currindex++;
            }else{//currinde递增，fillindex不变
                currindex++;
            }
        }
        return result;
    }


}