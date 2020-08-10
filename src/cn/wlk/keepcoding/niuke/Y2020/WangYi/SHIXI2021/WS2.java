package cn.wlk.keepcoding.niuke.Y2020.WangYi.SHIXI2021;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/4/7 20:21
 * author:WLK
 *
 * AC
 */

public class WS2 {
 static    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Test
    public void test() {
        WS2 t = new WS2();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] ms = new int[m];
        for(int i = 0;i<m;i++){
            ms[i] = scanner.nextInt();
        }
        System.out.println(func(n,ms));
    }
    public static int func(int n,int[] ms){
        threadLocal.get();
        int[] countArr = new int[n+1];
        int result = 0;
        for(int i = 0;i<ms.length;i++) {
            int x = ms[i];
            countArr[x]++;
            if (countScore(countArr)) {
                result++;
                for (int k = 1; k <= n; k++) {
                    countArr[k]--;
                }
            }
        }
        return result;
    }

    //判断是否得分
    public static boolean countScore(int[] arr){
        boolean isEmpty = false;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]==0){
                isEmpty=true;
            }
        }
        return  !isEmpty;
    }

}
