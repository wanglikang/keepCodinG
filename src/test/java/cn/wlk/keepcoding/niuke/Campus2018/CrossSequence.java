package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/26 10:27
 * author:WLK
 */

/**
 * 题目描述 交错序列
 * <p>
 * 我们定义一个由数字 0 和 1 组成的序列是交错序列，当且仅当在这个序列中 0 和 1 是轮流 出现的，比如，0，010，10101 都是交错序列。
 * <p>
 * 现在给出了一个由数字 0 和 1 组成的序列𝐴，它可能不是一个交错序列，但是你可以从这个 序列中选择一些数字出来，按他们在序列𝐴中原有的相对顺序排列(即选取𝐴的一个子序列)， 使得你最后得到的是一个交错序列。问这样能得到的交错序列的最长长度是多少。
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * <p>
 * 第一行包含一个整数𝑛，表示输入序列的长度。1 ≤ 𝑛 ≤ 105
 * 第二行包含𝑛个 0 或 1，表示对应的序列。
 * 输出描述:
 * <p>
 * 输出能够得到的最长交错序列的长度。
 * <p>
 * 示例1
 * 输入
 * <p>
 * 3
 * 0 1 0
 * <p>
 * 输出
 * <p>
 * 3
 * <p>
 * 示例2
 * 输入
 * <p>
 * 8
 * 1 1 0 0 1 1 0 0
 * <p>
 * 输出
 * <p>
 * 4
 *
 * 解法：设dp数组
 *      dp[i]的意思是：从str[0...i]为止所能组成的最长长度
 *          dp[0]=1
 *          dp[1]=str[0]==str[1]?1:2;
 *          dp[i]的取值来源于
 *              1、str[i]!=str[i-1]:则dp[i]=dp[i-1]+1
 *              2、否则，判断str[i]!=str[i-2],则dp[i]=dp[i-2]+1
 *                  3、否则，dp[i]=dp[i-2];
 *       最后dp[len-1]的值即为所求的最长长度
 *
 */
public class CrossSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] str = new char[n];
        int i = 0;
        while (i < n) {
            str[i] = scanner.next().toCharArray()[0];
            i++;
        }
        if(n==1){
            System.out.println(1);
            return ;
        }
        int dp[]=new int[n];
        dp[0]=1;
        dp[1]=str[0]==str[1]?1:2;
        for(int j = 2;j<n;j++){
            if(str[j]!=str[j-1]){
                dp[j]=dp[j-1]+1;
            }else {
                if(str[j]==str[j-2]){
                    dp[j]=dp[j-2];
                }else dp[j]=dp[j-2]+1;
            }
        }
        System.out.println(dp[n-1]);


    }
}
