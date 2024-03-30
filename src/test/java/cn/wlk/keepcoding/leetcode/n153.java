package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/3/2 16:43
 * author:WLK
 *
 * 153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * 解法：同 cn.wlk.keepcoding.SwordOffe2.TP011
 */

public class n153 {

    @Test
    public void test() {
        n153 t = new n153();
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
