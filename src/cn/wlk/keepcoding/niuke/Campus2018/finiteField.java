package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 2019/3/26 12:25
 * author:WLK
 */

/**
 * 题目描述 有限域
 * <p>
 * <p>
 * 在抽象代数中，我们学过一个关于有限域的定理：存在一个大小为q的有限域当且仅当q是某个素数p的方幂，即q=pk ,
 * 输入描述:
 * <p>
 * 第一行包含一个整数，数的范围在[1,10000]
 * <p>
 * 输出描述:
 * <p>
 * 输出阶数不超过
 * <p>
 * 示例1
 * 输入
 * <p>
 * 1
 * <p>
 * 输出
 * <p>
 * 0
 * 说明
 * 示例2
 * 输入
 * 37
 * 输出
 * 19
 * 说明
 * 当n 为 37 时，在 1-37 范围内，以下 19 个整数可以表示成某个素数的方幂：
 * 2，3，4，5，7，8，9，11，13，16，17，19，23，25，27，29，31，32，37。
 *
 *  解法：找素数，，再乘方判断是否在范围内？？
 *      先求1到n之间的所有素数集合，计数
 *          在对每个集合内的素数，计算k次幂，要求k次幂不超过n，计数
 *      求总计数即可
 */
public class finiteField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 2;i<=n;i++){
            if(isPrime(i)){
                stack.push(i);
                result ++;
//                System.out.print(i+" ");
            }
        }
//        System.out.println();
        while(!stack.isEmpty()){
            int t = stack.pop();
            for(int m = t*t;m<n;m*=t){
                if(m<n){
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    public static boolean isPrime(int n ){
        if(n==1)
            return true;
        for(int i = 2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

}
