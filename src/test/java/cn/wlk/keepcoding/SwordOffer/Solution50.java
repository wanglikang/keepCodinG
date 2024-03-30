package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/4 14:56
 * author:WLK
 * 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 解法：使用hash的思想，设本来在i下标的元素应该是i，否则，与numbers[i]进行交换。
 * 若numbers[numbers[i]]==numbers[i],则numbers[i]就是那个重复的
 */
public class Solution50 {
    @Test
    public void test() {
        Solution50 t = new Solution50();
        int[] arr = {2,3,1,0,2,5,3};
//        int[] arr = {1,2,3,2,2,3,3,2,4,4,2,1,4,2,1,2};
//        int[] arr = {2,4,3,1,4};
        int[] result = {0};
        t.duplicate(arr, arr.length,result);
        System.out.println(result[0]);
    }

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,
    //    so using duplication[0] = ? in implementation;
    //    Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * 使用hash的思想，设本来在i下标的元素应该是i，否则，与numbers[i]进行交换，
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null){
            return false;
        }
        int i = 0,j;
        for(;i<length;){
            j = i;
            if(numbers[i]==i) {
                i++;
                continue;
            }else if(numbers[numbers[j]]==numbers[j]){
                duplication[0]=numbers[j];
                return true;
            }else {
                if(numbers[j] != i) {
                    swap(numbers, i, numbers[j]);
                }
//                i = numbers[i];
            }
        }
        return false;

    }
    public void swap(int[] arr,int i,int j){
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

}
