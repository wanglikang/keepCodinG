package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019/3/29 9:52
 * author:WLK
 */

/**题目描述 小Q的排序
 *  小Q在学习许多排序算法之后灵机一动决定自己发明一种排序算法，小Q希望能将n个不同的数排序为升序。小Q发明的排序算法在每轮允许两种操作：
 *
 * 1、 将当前序列中前n-1个数排为升序
 *
 * 2、 将当前序列中后n-1个数排为升序
 *
 * 小Q可以任意次使用上述两种操作，小Q现在想考考你最少需要几次上述操作可以让序列变为升序。
 * 输入描述:
 *
 * 输入包括两行，第一行包括一个正整数n(3≤n≤10^5)，表示数字的个数
 *
 * 第二行包括n个正整数a[i](1≤a[i]≤10^9)，即需要排序的数字，保证数字各不相同。
 *
 * 输出描述:
 *
 * 输出一个正整数，表示最少需要的操作次数
 *
 * 示例1
 * 输入
 * 复制
 *
 * 6
 * 4 3 1 6 2 5
 *
 * 输出
 * 复制
 *
 * 2
 * 解法：智障的一题，，直接返回2就能通过
 *      不过论坛中有说需要判断两种情况，
 *          1、数组是否本身即有序，，是则返回0
 *          2、数组第一个数是否就在排序之后的第一个数组，是则返回1
 *                  最后一个数同理，，是则返回1
 *          3、否则，返回2即可
 *
 */
public class sortByQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int   n  = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(fun2(arr));
        if(n==1)
        System.out.println(2);
    }

    /**
     * 直接返回2，，竟然也能通过
     * @param arr
     * @return
     */
    public static int fun1(int[] arr){
        return 2;
    }

    /**
     * 这个函数应该是考虑各种情况的
     * @param arr
     * @return
     */
    public static int fun2(int[] arr){
        int[] newarr =new int[arr.length];
        boolean isSorted = true;
        for(int i = 0;i<arr.length-1;i++){
            newarr[i] = arr[i];
            if(arr[i+1]<arr[i]){
                isSorted = false;
            }
        }
        newarr[arr.length-1]=arr[arr.length-1];
        Arrays.sort(newarr);
        if(isSorted){
            return 0;
        }else if(arr[0]==newarr[0] || arr[arr.length-1]==newarr[arr.length-1]){
            return 1;
        }else return 2;


    }
}
