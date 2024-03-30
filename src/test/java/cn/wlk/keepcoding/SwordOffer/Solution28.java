package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019/4/2 10:47
 * author:WLK
 */

/**
 * 题目描述 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution28 {
    @Test
    public void test() {

    }

    /**
     * 使用hash表，比较简单，但一般不符合要求
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution_Hash(int[] array) {

        return 0;
    }


    /**
     * 先排个序，则出现次数大于一半的数字一定会在最中间的那个，但时间复杂度就不是0（N)了
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution_sort(int[] array) {
        Arrays.sort(array);
        int midindex = array.length/2;
        int mid = array[array.length/2];
        int count = 1;
        int left = midindex-1,right = midindex+1;
        while (array[left--]==mid)count++;
        while (array[right++]==mid)count++;

        if(count>array.length/2)
            return array[array.length/2];
        else return 0;
    }

    /**
     * 对于相似的问题：求出现次数大于N/K的数
     * 左神的方法：每次减去不同的K个数，剩到最后的那个可能是出现次数大于N/K的数字
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        //本题是K=2的情况
        int cand = 0;
        int times = 0;
        for(int i = 0;i<array.length;i++){
            if(times==0){
                cand = array[i];
                times = 1;
            }else if(array[i]==cand){
                times++;
            }else times--;
        }
        times = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i] == cand){
                times++;
            }
        }
        if(times>array.length/2){
            return cand;
        }else return 0;

    }
}
