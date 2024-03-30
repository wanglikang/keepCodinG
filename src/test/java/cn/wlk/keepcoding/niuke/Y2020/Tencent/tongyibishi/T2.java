package cn.wlk.keepcoding.niuke.Y2020.Tencent.tongyibishi;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/4/26 21:12
 * author:WLK
 */

public class T2 {

    @Test
    public void test() {
        T2 t = new T2();
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int k = scanner.nextInt();
        while(k-->0){
            int n = scanner.nextInt();
            int[][] a = new int[n][2];
            int[][] b = new int[n][2];
            for(int i = 0;i<n;i++){
                a[i][0] = scanner.nextInt();
                a[i][1] = scanner.nextInt();
            }
            for(int i = 0;i<n;i++){
                b[i][0] = scanner.nextInt();
                b[i][1] = scanner.nextInt();
            }
            System.out.println(String.format("%.3f",func(a,b)));
        }
    }

    public static double func(int[][] a,int[][] b){
        int n = a.length;
        double minDistance =Double.MAX_VALUE;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                double d = distance(a[i][0],a[i][1],b[j][0],b[j][1]);
                if(minDistance>d){
                    minDistance = d;
                }
            }
        }
        return  minDistance;
    }

    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

}
