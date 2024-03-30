package cn.wlk.keepcoding.niuke.Y2020.WangYi;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 2020/4/5 21:47
 * author:WLK
 * 网易2020校招笔试- Java 开发工程师（提前批）
 * 企业提供原题
 * 01:31:42
 * 13/16
 * [编程题]序列交换
 *
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 * 小易给你一个包含n个数字的数组。你可以对这个数组执行任意次以下交换操作：
 * 对于数组中的两个下标i,j(1<=i,j<=n)，如果为奇数，就可以交换a_i和a_j。
 *
 * 现在允许你使用操作次数不限，小易希望你能求出在所有能通过若干次操作可以得到的数组中，字典序最小的一个是什么。
 *
 * 输入描述:
 *
 * 第一行一个整数n；
 * 第二行n个整数a_1,a_2,..,a_n，表示数组，每两个数字之间用一个空格分隔。
 * 输入保证。
 *
 *
 * 输出描述:
 *
 * n个整数，每两个整数之间用一个空格分隔，表示得到的字典序最小的数组。
 *
 *
 * 输入例子1:
 *
 * 4
 * 7 3 5 1
 *
 *
 * 输出例子1:
 *
 * 7 3 5 1
 *
 *
 * 输入例子2:
 *
 * 10
 * 53941 38641 31525 75864 29026 12199 83522 58200 64784 80987
 *
 *
 * 输出例子2:
 *
 * 12199 29026 31525 38641 53941 58200 64784 75864 80987 83522
 */

public class W4 {

    @Test
    public void test() {
        W4 t = new W4();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Long[] arr = new Long[n];

        boolean hasOdd = false;
        boolean hasEve = false;
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextLong();
            if(arr[i]%2==1){
                hasOdd = true;
            }
            if(arr[i]%2==0){
                hasEve = true;
            }
        }
        Long[] re = func(arr, hasOdd,hasEve);
        for(int i = 0;i<re.length;i++){
            if(i!=re.length-1) {
                System.out.print(re[i]+" ");
            }else{
                System.out.println(re[i]);
            }
        }

    }
    public static  Long[]  func(Long[] arr,boolean hasOdd,boolean hasEve) {

        if (!hasOdd || !hasEve) {
            return arr;
        }
        Comparator<Long> cmp = new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    String s1 = o1 + "";
                    String s2 = o2 + "";
                    return s1.compareTo(s2);
                }
            };
        Arrays.sort(arr, cmp);
        return arr;
    }
}
