package cn.wlk.keepcoding.niuke.Y2016.BaiDu1;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/3/29 13:28
 * author:WLK
 * [编程题]裁减网格纸
 *
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 32M，其他语言64M
 * 度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，每个点可以用一对整数x，y来表示。度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。然后把这个正方形剪下来。问剪掉正方形的最小面积是多少。
 *
 * 输入描述:
 *
 * 第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点
 *
 *
 * 输出描述:
 *
 * 一行输出最小面积
 *
 *
 * 输入例子1:
 *
 * 2
 * 0 0
 * 0 3
 *
 *
 * 输出例子1:
 *
 * 9
 *
 */

public class B2 {

    @Test
    public void test() {
        B2 t = new B2();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            System.out.println(func(arr));

        }
    }
    public static long func(int[][] arr){
        int maxX,maxY,minX,minY;
        maxX = maxY = Integer.MIN_VALUE;
        minX = minY = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++){
            maxX = Math.max(arr[i][0],maxX);
            minX = Math.min(arr[i][0],minX);
            maxY = Math.max(arr[i][1],maxY);
            minY = Math.min(arr[i][1],minY);
        }

        long len = Math.max((maxX-minX),maxY-minY);
        return len*len;

    }

}
