package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2020/3/6 22:23
 * author:WLK
 *
 * 面试题61. 扑克牌中的顺子
 *
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 *
 *
 * 限制：
 *
 * 数组长度为 5
 *
 * 数组的数取值为 [0, 13] .
 *
 *
 * 解法：先排序，再求0的个数，再检查后续的元素是否有重复，再统计最大元素和最小元素（除0外）的差值
 */

public class TP061 {

    @Test
    public void test() {
        TP061 t = new TP061();
        int[] nums =  new int[]{13,13,9,12,10};
        System.out.println(t.isStraight(nums));

    }


    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        int i;
        for(i= 0;i<5;i++){
            if(nums[i]==0){
                zeroCount++;
            }else{
                break;
            }
        }
        //检查是否有重复元素
        for(int ii = i+1;ii<=4;ii++){
            if(nums[ii]==nums[ii-1]){
                return false;
            }
        }

        int a = nums[4]-nums[i];
        int b = 4-i;
        if(zeroCount+b >=a){
            return true;
        }else{
            return false;
        }
    }


}
