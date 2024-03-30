package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 2019/4/4 10:00
 * author:WLK
 * 和为S的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * <p>
 * 对应每个测试案例，输出两个数，小的先输出。
 * 解法：双指针
 */
public class Solution42 {
    @Test
    public void test() {
        Solution42 t = new Solution42();
        int[] arr = {1,2,3,3,4,4,4,5,6,7,8,9,10};
        t.FindNumbersWithSum(arr,6).stream().forEach(x->{
            System.out.print(x+" ");
        });
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int left = 0;
        int right = array.length-1;
        ArrayList<Integer> result = new ArrayList<>();
        while(left<right){
            int s   = array[left]+array[right];
            if(s ==sum){
                result.add(array[left]);
                result.add(array[right]);
                return result;
            }else if(s>sum){
                right--;
            }else {
                left++;
            }
        }
        return result;
    }
}
