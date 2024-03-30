package cn.wlk.keepcoding.niuke.Y2016.BaiDu1;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/3/29 12:46
 * author:WLK
 *
 * [编程题]罪犯转移
 *
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 32M，其他语言64M
 * C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。现在为了方便管理，市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式（一组测试用例可能包含多组数据，请注意处理）？
 *
 * 输入描述:
 *
 * 第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)
 *
 *
 * 输出描述:
 *
 * 一行输出答案。
 *
 *
 * 输入例子1:
 *
 * 3 100 2
 * 1 2 3
 *
 *
 * 输出例子1:
 *
 * 2
 *
 *
 */

public class B1 {

    @Test
    public void test() {
        B1 t = new B1();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            int c = scanner.nextInt();
            int[] arr = new int[n];
//            System.out.println(n + ":" + t + ":" + c);
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
//                System.out.println(i);
            }
//            System.out.println();
            System.out.println(func(arr, n, t, c));
        }

    }

    public static int func(int[] arr,int n,int t,int c){
        int sum = 0;
        int count = 0;
        for(int i = 0;i<c;i++){
            sum+=arr[i];
        }
        if(sum<=t){
            count++;
        }
        for(int i =c;i<n;i++){
            sum-=arr[i-c];
            sum+=arr[i];
            if(sum<=t){
                count++;
            }
        }
        return count;
    }
}
