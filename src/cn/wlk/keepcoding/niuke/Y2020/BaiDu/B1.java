package cn.wlk.keepcoding.niuke.Y2020.BaiDu;

import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 2020/3/29 19:47
 * author:WLK
 */

public class B1 {
    static int size = 1000000000;
    static long[] numbers = new long[size];
    static{
        numbers[0] = 1;
        numbers[1] = 1;
        numbers[2] = 1;
        for(int i = 3;i<Math.sqrt(size);i++){
            for(int j = 2;j<Math.sqrt(size);i++){
                numbers[i*j]=1;
            }
        }
    }
    @Test
    public void test() {
        B1 t = new B1();
        System.out.println(B1.gcd(12,38));
        System.out.println(B1.lcm(12,38));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        System.out.println(func(n));

    }

    public static long func(int n ){
        int t1=-1,t2=-1;
        for(int i =n;n>=2;n--){
            if(numbers[i]==0){
                if(t1!=-1) {
                    t1 = i;
                } else{
                    t2 = i;
                    break;
                }
            }
        }
        return t1*t2-1;

    }






    public static long lcm(long a,long b){
        if(a<b){
            //保证a>=b
            long t = a;
            a = b;
            b = t;
        }

        for(int i = 2;i<a;i++){
            long t = b*i;
            if(t%a==0){
                return t;
            }
        }
        return a*b;
    }

    public static int gcd(int a,int b){
        if(a<b){
            //保证a>=b
            int t = a;
            a = b;
            b = t;
        }
        int t ;
        while(b!=0){
            t = a%b;
            a= b;
            b = t;
        }
        return a;
    }


}
