package cn.wlk.keepcoding.niuke.Y2020.WangYi;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020/4/5 22:07
 * author:WLK
 *
 * 网易2020校招笔试- Java 开发工程师（提前批）
 * 企业提供原题
 * 01:51:44
 * 14/16
 * [编程题]数字圆环
 *
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 * 小易有一个长度为n的数字数组a_1, a_2, …, a_n。
 *
 * 问你是否能用这n个数字构成一个环(首尾连接)，使得环中的每一个数字都小于它相邻的两个数字的和(每个数字都必须使用并且每个数字只能使用一次)。
 *
 * 输入描述:
 *
 * 第一行包含一个整数t(1<=t<=10)，表示测试用例的组数。
 * 每个测试用例输入如下：
 * 第一行一个整数n，表示数字的个数；
 * 第二行n个整数a_1, a_2, …, a_n，每两个整数之间用一个空格分隔。
 * 输入数据保证
 *
 * 。
 *
 *
 * 输出描述:
 *
 * 输出应该包含t行，对于每组用例，若能输出"YES"，否则输出"NO"。
 *
 *
 * 输入例子1:
 *
 * 1
 * 5
 * 17 6 17 11 17
 *
 *
 * 输出例子1:
 *
 * YES
 *
 *
 * 输入例子2:
 *
 * 1
 * 3
 * 1 2 4
 *
 *
 * 输出例子2:
 *
 * NO
 */

public class W5 {

    @Test
    public void test() {
        W5 t = new W5();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        while(k-->0){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i]  = scanner.nextInt();
            }
            System.out.println(func(arr));
        }
    }
    public static String func(int[] arr){
        Arrays.sort(arr);
        int n= arr.length;
        if(arr[0]+arr[n-2]<=arr[n-1]){
            return "NO";
        }else{
            return "YES";
        }
    }
}
