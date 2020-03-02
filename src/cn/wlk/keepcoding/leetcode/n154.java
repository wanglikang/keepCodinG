package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/3/2 16:44
 * author:WLK
 *
 * 154. 寻找旋转排序数组中的最小值 II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 *
 * 示例 1：
 *
 * 输入: [1,3,5]
 * 输出: 1
 *
 * 示例 2：
 *
 * 输入: [2,2,2,0,1]
 * 输出: 0
 *
 * 说明：
 *
 *     这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 *     允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 *
 * 解法：同153
 */

public class n154 {

    @Test
    public void test() {
        n154 t = new n154();
    }

    public int findMin(int[] numbers) {

        int n = numbers.length;
        int left  = 0;
        int right = n-1;
        int midindex;
        if(numbers[0]<numbers[n-1]){
            return numbers[0];
        }
        while(left<right){
            midindex = left+(right-left)/2;
            if(numbers[midindex]  > numbers[right]){
                left = midindex+1;
            }else if(numbers[midindex] < numbers[right]){
                right = midindex;
            }else{
                right = right-1;
            }
        }

        return numbers[left];
    }


}
