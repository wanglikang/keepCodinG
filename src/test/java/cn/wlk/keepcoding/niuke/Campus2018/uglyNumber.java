package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/4/1 10:11
 * author:WLK
 */

/**题目描述 寻找丑数
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 输入描述:
 *
 * 整数N
 *
 * 输出描述:
 *
 * 第N个丑数
 *
 * 示例1
 * 输入
 * 复制
 *
 * 6
 *
 * 输出
 * 复制
 *
 * 6
 *
 * 解法：依次判断即可
 *          时间复杂度太高，，更好的解法需要参考剑指offer的src/Soluyion33的解法
 *
 *
 */
public class uglyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n<=6){
            System.out.println(n);
            return;
        }
        int count = 6;
        int i = 7;
        while(count<n){
            if(isUgly(i)){
                count++;
            }
            i++;
        }
        System.out.println(i-1);
    }
    public static boolean isUgly(int n){
        if(n==1)
            return true;
        if(n%5==0){
            return isUgly(n/5);
        }else if(n%3==0){
            return isUgly(n/3);
        }else if(n%2==0){
            return isUgly(n/2);
        }else return false;
    }
}
