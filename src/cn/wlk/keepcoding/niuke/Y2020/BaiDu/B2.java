package cn.wlk.keepcoding.niuke.Y2020.BaiDu;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020/3/29 19:51
 * author:WLK
 */

public class B2 {

    @Test
    public void test() {
        B2 t = new B2();
        long[] arr = new long[]{1,0,3};
        System.out.println(B2.func(arr));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextLong();
        }
        System.out.println(func(arr));
    }
    public static int func(long[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int k =0;
        while(arr[n-1]>=n){
            if(arr[n-1]-arr[n-2]>n){
                ;
            }
            arr[n-1]-=n;
            for(int i = n-2;i>=0;i--){
                arr[i]+=1;
            }
            Arrays.sort(arr);
            k++;
        }
        return k;
    }

}
