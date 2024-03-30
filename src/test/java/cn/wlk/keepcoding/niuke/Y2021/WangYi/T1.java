package cn.wlk.keepcoding.niuke.Y2021.WangYi;

import java.util.Scanner;

/**
 * 2020/8/8 15:03
 * author:WLK
 */

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
//        int[] arrs = new int[n];
        long sum  = 0;
        for(int i = 0;i<n;i++){
            int x = scanner.nextInt();
            if(x==1){
                continue;
            }else if(x%2==0){
                sum+=x/2;
            }else{
                sum+=x/2;
            }
        }
        System.out.println(sum);

    }
}
