package cn.wlk.keepcoding.niuke.Campus2018;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/3/8 10:04
 * author:WLK
 */

public class Tencent20183 {

    @Test
    public void test() {
        Tencent20183 t = new Tencent20183();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
//        n = scanner.nextInt();
        int m ;
//        m = scanner.nextInt();

//        n = 58;
//        m = 80;

//        n = 3;
//        m = 7;
        n = 100;
        m = 382;
        System.out.println(func(n,m));


    }

    public static int func(int n,int m){
        for(int target = (int)Math.ceil(Math.sqrt(m*2.0));target>0;target--){
            if(judge(n,m,target)){
                return target;
            }
        }

        return 1;
    }


    public static boolean judge(int n,int m,int target){
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum+=target;
            target = (int)Math.ceil(target*1.0/2);
        }
        return sum <=m;
    }
}
