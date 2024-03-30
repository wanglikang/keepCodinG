package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/28 10:54
 * author:WLK
 */

/**题目描述 菲波那切数列
 *
 *
 */
public class fibonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n==0){
            System.out.println(0);
        }else if(n==1 || n==2){
            System.out.println(1);
        }else {
            int[] fibo = new int[n+1];
            fibo[0]=0;
            fibo[1] = 1;
            fibo[2] = 1;
            for(int i = 3;i<=n;i++){
                fibo[i]=fibo[i-1]+fibo[i-2];
            }
            System.out.println(fibo[n]);

        }
    }
}
