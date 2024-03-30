package cn.wlk.keepcoding.niuke.Y2020.A360;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/3/28 19:40
 * author:WLK
 */

public class Q1 {

    @Test
    public void test() {
        Q1 t = new Q1();
        for(int i = 0;i<=15;i++) {
            System.out.println(i+":"+Q1.func(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(func(n));

    }

    public static int func(int n){
        int[] number = new int[]{5,3,3,2,4,1};
        int[] price = new int[]{1,2,2,2,5,3};

        int available_cash = n;
        int sum = 0;
        for(int i = 0;i<6;i++){
            if(available_cash>0){
                if(available_cash>=price[i]){
                    sum+=number[i];
                    available_cash-=price[i];
                }
            }else{
                break;
            }
        }
        return sum;
    }


}
