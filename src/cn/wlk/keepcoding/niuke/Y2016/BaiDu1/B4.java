package cn.wlk.keepcoding.niuke.Y2016.BaiDu1;

import com.sun.javafx.binding.StringFormatter;
import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/3/29 13:51
 * author:WLK
 *
 * [编程题]蘑菇阵
 *
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 32M，其他语言64M
 * 现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。现在A想要拜访B，由于她只想去B的家，所以每次她只会走(i,j+1)或(i+1,j)这样的路线，在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),问：A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？
 *
 * 输入描述:
 *
 * 第一行N，M，K(1 ≤ N,M ≤ 20, k ≤ 100),N,M为草地大小，接下来K行，每行两个整数x，y，代表(x,y)处有一个蘑菇。
 *
 *
 * 输出描述:
 *
 * 输出一行，代表所求概率(保留到2位小数)
 *
 *
 * 输入例子1:
 *
 * 2 2 1
 * 2 1
 *
 *
 * 输出例子1:
 *
 * 0.50
 *
 *
 */

public class B4 {

    @Test
    public void test() {
        B4 t = new B4();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] mohu = new int[n][m];
        int k = scanner.nextInt();
        for(int i = 0;i<k;i++){
            int nn = scanner.nextInt();
            int mm = scanner.nextInt();
            mohu[nn-1][mm-1] = 1;
        }
        if(k==0){
            System.out.println("0.00");
        }else {
            System.out.println(func1(n, m, mohu));
        }
    }

    public static String func1(int n,int m,int[][] arr){
        if(arr[0][0]==1){
            return "1.00";
        }
        int[][] dp = new int[n][m];
        int[][] dpmogu = new int[n][m];
        dp[0][0]= 0;
        for(int i = 1;i<n;i++){
            dp[i][0]=1;
            dp[0][i]=1;
            dpmogu[i][0] = arr[i][0]==1?1:dpmogu[i-1][0];
            dpmogu[0][i] = arr[0][i]==1?1:dpmogu[0][i-1];
        }

        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
                dpmogu[i][j] = arr[i][j]==1
                        ? dp[i-1][j]+dp[i][j-1]
                        : Math.max(dpmogu[i-1][j],dpmogu[i][j-1]);
            }
        }
        double r = dpmogu[n - 1][m - 1] * 1.0 / dp[n - 1][m - 1];
        return String.format("%.2f",r);
    }
}
