package cn.wlk.keepcoding.niuke.Y2020.Ali;

import org.junit.Test;

import java.util.Arrays;

import java.util.Scanner;

/**
 * 2020/4/9 22:56
 * author:WLK
 */

public class A1 {

    @Test
    public void test() {
        A1 t = new A1();
    }


    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] xys = new int[n][2];
        for(int i = 0;i<n;i++){
            xys[i][0] = scanner.nextInt();
            xys[i][1] = scanner.nextInt();
        }

        System.out.println(func(xys));
    }
    public static long func(int[][] xys){
        int n= xys.length;
        int[] xavg = new int[n];
        for(int i = 0;i<n;i++){
            xavg[i]=xys[i][0];
        }

        Arrays.sort(xavg);
        int mid = xavg[n/2];
        long result = 0;
        for(int i = 0;i<n;i++){
            result+=Math.abs(xavg[i]-mid);

        }
        return result;
    }

}
