package cn.wlk.keepcoding.niuke.Y2019;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/4/19 22:40
 * author:WLK
 *
 * 度小满2019秋招研发岗试卷
 * 01:40:05
 * 21/21
 * [编程题]字符串替换
 *
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 64M，其他语言128M
 *
 * 给定一个仅由小写字母x和y组成且长度不超过105的字符串，每次可以将字符串中的一个子串xy替换成字符串yyx，那么至少要替换多少次才能让字符串中不存在子串xy？
 *
 * 输入描述:
 *
 * 输入给定的字符串。
 *
 *
 * 输出描述:
 *
 * 输出最少替换次数对109+7取模后的结果。
 *
 *
 * 输入例子1:
 *
 * xxy
 *
 *
 * 输出例子1:
 *
 * 3
 *
 *
 */

public class DXM2019D1 {

    public  static  int MOD = 1000000007;
    @Test
    public void test() {
        DXM2019D1 t = new DXM2019D1();

        System.out.println(DXM2019D1.func("xxy"));
        System.out.println(DXM2019D1.func("xxyy"));
//        System.out.println(t.func("xyy"));
        /**
         xyx xy
         xyx yyx
         xyyyx yyx
         xyyyyyxyx
         xyyyyyyyxx
         yyx
         */
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(func(str));
    }
    public   static int func(String str){
        int n = str.length();
        int yCount = 0;
        int result = 0;
        for(int i = n-1;i>=0;i--){

            if(str.charAt(i)=='x'){
                result=(result+yCount)%MOD;
                yCount = (yCount *2) % MOD;
            }else {

                yCount = (yCount + 1) % MOD;
            }
        }

        return result;

    }

}
