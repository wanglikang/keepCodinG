package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 190. 颠倒二进制位
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 示例:
 *
 * 输入: 43261596
 * 输出: 964176192
 * 解释: 43261596 的二进制表示形式为
 * 00000010100101000001111010011100 ，
 *      返回 964176192，其二进制表示形式为
 * 00111001011110000010100101000000 。
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 */
//done

/**
 * 二进制操作
 */
public class n190 {
    public int reverseBits(int n) {
        int[] result = {n};
        for(int i = 0;i<32/2;i++){
            swapBIN(result,i);
        }
        return result[0];
    }
    public void swapBIN(int[] nums,int index){
        int i = 1<<(index);
        int j = 1<<(32-index-1);
//        Utils.showBinary(i);
//        Utils.showBinary(j);


        int n1 =(nums[0]&i);
        int n2 =(nums[0]&j);

        if(n1==i){//是1
            nums[0] = nums[0]|j;
        }else {//是0
            nums[0] = nums[0]&(~j);
        }


        if(n2==j){//是1
            nums[0] = nums[0]|i;
        }else {//是0
            nums[0] = nums[0]&(~i);
        }

        //Utils.showBinary(nums[0]);
        //System.out.println();
    }

    @Test
    public void test() {
        n190 t = new n190();
        int i  = 43261596;
        System.out.println(t.reverseBits(i));

    }

}
