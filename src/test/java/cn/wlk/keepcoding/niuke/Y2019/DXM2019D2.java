package cn.wlk.keepcoding.niuke.Y2019;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 2020/4/19 23:10
 * author:WLK
 *
 * 度小满2019秋招研发岗试卷
 * 01:41:20
 * 20/21
 * [编程题]数字的情绪
 *
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 64M，其他语言128M
 *
 * 每个整数都希望可以整除很多数字，特别是它自身包含的数字，我们将整数分为三类：
 *
 * 1. 数字可以整除它包含的一部分数字，比如72，由，7和2两种数字组成，72可以整除2，我们称这个数字是开心的，用”H”表示。
 *
 * 2. 数字不能整除它包含的任何数字，比如73，由，7和3两种数字组成，73不能整除任何数，我们称这个数字是沮丧的，用”S”表示。
 *
 * 3. 数字可以整除它包含的所有数字，比如12，既可以整除1又可以整除2，我们称它是一个非常棒的数，用“G”表示。  (0可以被任何数整除。)
 *
 * 输入描述:
 *
 * 输入第一行包含一个整数T，表示数据组数(1<=T<=100). 接下来T行，每行包含一个正整数n(1<=n<=10^12)，表示需要你判断的数字。
 *
 *
 * 输出描述:
 *
 * 对于每组测试数据输出一行，“H”，“S”或“G”。表示整数种类。
 *
 *
 * 输入例子1:
 *
 * 3
 * 72
 * 73
 * 12
 *
 *
 * 输出例子1:
 *
 * H
 * S
 * G
 *
 *
 */

public class DXM2019D2 {

    @Test
    public void test() {
        DXM2019D2 t = new DXM2019D2();
//        System.out.println(DXM2019D2.judge(72));
//        System.out.println(DXM2019D2.judge(73));
//        System.out.println(DXM2019D2.judge(12));
        System.out.println(DXM2019D2.judge(999999097343L));//H


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long l;
        while(n-->0){
            l = scanner.nextLong();
            System.out.println(judge(l));

        }

    }


    public  static  String judge(long n){
        ArrayList<Long> arr =new ArrayList<>(12);
        long nn =  n;
        while (nn>0){
            arr.add(nn%10);
            nn =  nn/10;
        }
        int canDivNum = 0;
        for(int i = 0;i<arr.size();i++){
            if(arr.get(i)==1){
                canDivNum++;
            }else if(arr.get(i)==0) {
                canDivNum++;
            }else if(n%arr.get(i)==0){
                    canDivNum++;
            }

        }

        if(canDivNum==0){
            return "S";//S
        }
        if(canDivNum==arr.size()){
            return "G";//G
        }
        return "H";//H

    }
}
