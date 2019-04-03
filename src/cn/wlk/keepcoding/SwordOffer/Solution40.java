package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2019/4/3 20:15
 * author:WLK
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 解法：使用异或运算的特性：某个数和其自身异或，结果为0
 *      将全部数字进行异或，然后找最后一个为1的位作为标志，将数组分开，分别进行异或，则分别最后的异或结果即为答案
 */
public class Solution40 {
    @Test
    public void test() {
        Solution40 t = new Solution40();
        int[] arr ={1,1,3,3,5,5,2,2,7,23,23,34};
        int[] num1 = {0};
        int[] num2 = {0};
        t.FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0]+":"+num2[0]);
    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int nox = array[0];
        for(int i = 1;i<array.length;i++){
            nox^=array[i];
        }
        int t = 0;
        for(t = 1;;){
            if((nox&t)!=0){
                break;
            }else t=t<<1;
        }
        int nox1 = nox;
        int nox2 = nox;
        for(int i = 0;i<array.length;i++){
            if((array[i]&t)==0){
                nox1^=array[i];
            }else {
                nox2^=array[i];
            }
        }
        num1[0]=nox1;
        num2[0]=nox2;
    }


}
