package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/4/1 9:11
 * author:WLK
 */

/**题目描述 整数乘积最大化
 *  给出一个整数n，将n分解为至少两个整数之和，使得这些整数的乘积最大化，输出能够获得的最大的乘积。
 * 例如：
 * 2=1+1，输出1；
 * 10=3+3+4，输出36。
 * 输入描述:
 *
 * 输入为1个整数
 *
 * 输出描述:
 *
 * 输出为1个整数
 *
 * 示例1
 * 输入
 * 复制
 *
 * 10
 *
 * 输出
 * 复制
 *
 * 36
 *
 * 解法：动态规划，，dp[i]表示数字i所对应的乘积最大值
 *               dp[i]=for t=1 to i,MAX(t*max(i-t,dp[i-t])
 *
 */
public class maxProducetOfSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  n = scanner.nextInt();
        if(n<=2){
            System.out.println(1);
            return ;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i = 3;i<=n;i++){
            for(int j = 1;j<=i;j++){
                dp[i]=Math.max(dp[i],j*Math.max(dp[i-j],i-j));
            }
        }
//        for(int i = 0;i<=n;i++)
//            System.out.print(i+"\t");
//        System.out.println();
//        for(int i = 0;i<=n;i++){
//            System.out.print(dp[i]+"\t");
//        }
//        System.out.println();
        System.out.println(dp[n]);
//9=2+2+2+3
        //8*3=24
        //3+3+3=27
    }















}





















