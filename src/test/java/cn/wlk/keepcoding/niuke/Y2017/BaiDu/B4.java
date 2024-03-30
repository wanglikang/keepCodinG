package cn.wlk.keepcoding.niuke.Y2017.BaiDu;

import org.junit.Test;

/**
 * 2020/3/28 17:23
 * author:WLK
 *
 * 百度2017春招笔试真题编程题集合
 * 00:19:43
 * 4/5
 * [编程题]有趣的排序
 *
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 32M，其他语言64M
 * 度度熊有一个N个数的数组，他想将数组从小到大 排好序，但是萌萌的度度熊只会下面这个操作：
 * 任取数组中的一个数然后将它放置在数组的最后一个位置。
 * 问最少操作多少次可以使得数组从小到大有序？
 *
 * 输入描述:
 *
 * 首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)
 *
 *
 * 输出描述:
 *
 * 输出一个整数表示最少的操作次数。
 *
 *
 * 输入例子1:
 *
 * 4
 * 19 7 8 25
 *
 *
 * 输出例子1:
 *
 * 2
 *
 *
 */

public class B4 {

    @Test
    public void test() {
        B4 t = new B4();
    }


    public static int func(int[] arr){

        return 0;
    }
    public static int findMinAngle(int[] arr){
        int n = arr.length;
        int minIndex = 0;
        for(int i = n-2;i>0;i++){
            if(arr[i]<arr[i+1] && arr[i-1] >=arr[i]){
                if(arr[minIndex]>=arr[i]){
                    minIndex = i;
                }

            }

        }
        return 1;
    }
}
