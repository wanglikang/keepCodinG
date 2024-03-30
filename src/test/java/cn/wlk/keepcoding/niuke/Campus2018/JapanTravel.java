package cn.wlk.keepcoding.niuke.Campus2018;

import com.sun.corba.se.impl.oa.toa.TOA;

import java.util.Scanner;

/**
 * 2019/3/26 10:48
 * author:WLK
 */

/**
 * 题目描述 日本旅行
 * 楚乔、宇文玥和燕洵在日本旅行，经过了几天的游玩之后，钱包里出现了大量硬币，楚乔决定用钱包里的硬币为宇文玥和燕洵在自动贩卖机买水。楚乔的钱包里有1元、5元、10元、50元、100元和500元硬币各C1,C5,C10,C50,C100,C500枚。现在要用这些硬币来到自动贩卖机买价格为A的饮料，假设自动贩卖机所需的硬币金额必须是刚刚好，不能多也不能少，最少需要多少枚硬币？
 * <p>
 * 限制条件
 * <p>
 * 0≤ C1,C5,C10,C50,C100,C500≤1000000000
 * <p>
 * 0≤A≤1000000000
 * <p>
 * 依次输入C1,C5,C10,C50,C100,C500和A，以空格分隔，输出最少所需硬币数，如果该金额不能由所给硬币凑出，则返回NOWAY
 * <p>
 * 输入描述:
 * <p>
 * 依次输入C1,C5,C10,C50,C100,C500和A，以空格分隔
 * <p>
 * 输出描述:
 * <p>
 * 输出最少所需硬币数，如果该金额不能由所给硬币凑出，则返回NOWAY
 * 示例1
 * 输入
 * 3 2 1 3 0 2 620
 * <p>
 * 输出
 * 6
 *
 * 解法：从大到小一步一步减就行
 */
public class JapanTravel {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] number = {1, 5, 10, 50, 100, 500};
        int Total = scanner.nextInt();
        int remain = Total;
        int index = 5;
        int count = 0;
        while (index >= 0 & remain > 0) {
            if(number[index]>remain){
                index--;
                continue;
            }
            if (arr[index] > 0) {
                remain = remain - number[index];
                count++;
                arr[index]--;
            } else {
                index--;
            }
        }
        if (remain > 0) {
            System.out.println("NOWAY");
        } else System.out.println(count);

    }
}
