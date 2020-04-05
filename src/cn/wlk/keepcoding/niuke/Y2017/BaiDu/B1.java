package cn.wlk.keepcoding.niuke.Y2017.BaiDu;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020/3/28 17:04
 * author:WLK
 *
 * 百度2017春招笔试真题编程题集合
 * 00:01:55
 * 1/5
 * [编程题]买帽子
 *
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 32M，其他语言64M
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 *
 * 输入描述:
 *
 * 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
 *
 *
 * 输出描述:
 *
 * 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
 *
 *
 * 输入例子1:
 *
 * 10
 * 10 10 10 10 20 20 30 30 40 40
 *
 *
 * 输出例子1:
 *
 * 30
 */

public class B1 {

    @Test
    public void test() {
        B1 t = new B1();
    }

    public static void main(String[] argv){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(func(arr));
    }

    public static int func(int[] arr){
        Arrays.sort(arr);

        if(arr.length>2){
            int min = arr[0];
            int k = 1;
            for(int i = 1;i<arr.length;i++){
                if(min<arr[i]  && k<3){
                    min = arr[i];
                    k++;
                }
            }
            return k>=3?min:-1;
        }else{
            return -1;
        }
    }

}
