package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/29 9:27
 * author:WLK
 */

/**题目描述 倒水
 *  要把m升的水倒入n个相同的容器中（假设容器足够大），允许有的容量是空的，问共有多少种不同的倒法？（用k表示）5，1，1和1，5，1和1，1，5是同一种倒法。
 *
 *
 * 输入描述:
 *
 * 第一行是测试数据的数目x(0≤x≤20)。以下每行均包含二个整数m和n，以空格分开。1≤m，n≤10。
 *
 * 输出描述:
 *
 * 对输入的每行数据m和n，用一行输出相应的k。
 *
 * 示例1
 * 输入
 *
 * 1
 * 7 3
 *
 * 输出
 *
 * 8
 *
 * 解法：使用递归，f(m,n)代表m升水n个容器的倒法
 *              当m=0或n=1时，，只有一种倒法，返回1
 *              f(m,n)=f(m,n-1)//至少有一个容器是空的情况的倒法数
 *                         +
 *                     f(m-n,n)//每个容器至少一升水的倒法数
 *              此外，若n>m，则f(m,n)等于f(m,m)
 *
 *
 *
 */
public class dropWater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int m,n;
        for(int i = 0;i<k;i++){
            m = scanner.nextInt();
            n = scanner.nextInt();
            System.out.println(f(m,n));
        }
    }
    public static int f(int m,int n){
        if(m==0 || n ==1) {
            return 1;
        }else if(n>m){
            return f(m,m);
        }else {
            return f(m,n-1)+f(m-n,n);
        }
    }
}
