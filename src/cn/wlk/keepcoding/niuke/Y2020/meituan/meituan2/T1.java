package cn.wlk.keepcoding.niuke.Y2020.meituan.meituan2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020/3/19 18:59
 * author:WLK
 */

public class T1 {

    @Test
    public void test() {
        T1 t = new T1();
        long re = func(new long[]{1, 2, 3, 4, 5}, new long[]{1, 2, 3, 4, 6}, 5);
        System.out.println(re);
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr1 =new long[n];
        long[] arr2 =new long[n];
        for(int i  = 0;i<n;i++){
            arr1[i] = scanner.nextLong();
        }

        for(int i  = 0;i<n;i++){
            arr2[i] = scanner.nextLong();
        }

        long result = func(arr1, arr2, n);
        System.out.println(result);
    }

    public static long func(long[] arr1,long[] arr2,int n){
        if(n==1){
            return  Math.max(arr1[0],arr2[0]);
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(n==2){
            return Math.max(arr1[n-1]+arr1[n-2],arr2[n-1]+arr2[n-2]);
        }else{
            return Math.max(arr1[n-1]+arr1[n-2]+arr1[n-3],
                    arr2[n-1]+arr2[n-2]+arr2[n-3]);
        }
    }

}
