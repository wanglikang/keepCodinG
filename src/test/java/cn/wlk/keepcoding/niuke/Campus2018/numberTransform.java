package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/26 12:00
 * author:WLK
 */

/**题目描述 数字转换机
 *
 *  小Q从牛博士那里获得了一个数字转换机，这台数字转换机必须同时输入两个正数a和b，并且这台数字转换机有一个红色的按钮和一个蓝色的按钮：
 *
 * 当按下了红色按钮，两个数字同时加1。
 *
 * 当按下了蓝色按钮，两个数字同时乘2。
 *
 * 小Q现在手中有四个整数a，b，A，B，他希望将输入的两个整数a和b变成A，B（a对应A，b对应B）。因为牛博士允许小Q使用数字转换机的时间有限，所以小Q希望按动按钮的次数越少越好。请你帮帮小Q吧。
 *
 *
 *
 *
 * 输入描述:
 *
 * 输入包括一行，一行中有四个正整数a，b，A，B，（1≤a，b，A，B≤10^9）。
 *
 * 输出描述:
 *
 * 如果小Q可以完成转换，输出最少需要按动按钮的次数，否则输出-1。
 *
 * 示例1
 * 输入
 *
 * 100  1000  202  2002
 *
 * 输出
 *
 * 2
 *
 * 解法：
 *      对A,B
 *              若一奇一偶，则直接返回-1
 *              若都为奇数，则各自-1
 *              若都为偶数，则各自÷2，
 *           记录步数
 *           直到A==a &&B==b为止，
 *
 *
 */
public class numberTransform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(),b = scanner.nextInt(),A = scanner.nextInt(),B = scanner.nextInt();

        int count = 0;
        while(A>0&&B>0){
            if(A%2==0 && B%2==0){//两者都为偶数
                A = A/2;
                B = B/2;
            }else if(A%2==1||B%2==1){//两者都为奇数
                A= A-1;
                B = B-1;
            }else{//一奇一偶，则不可能转换成功
                System.out.println(-1);
                break;
            }
            count++;
            if(A==a &&B==b){
                break;
            }
        }
        if(A==a &&B==b){
            System.out.println(count);
        }else System.out.println(-1);


    }

}
