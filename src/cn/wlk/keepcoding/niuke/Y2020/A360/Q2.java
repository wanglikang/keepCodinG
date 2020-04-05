package cn.wlk.keepcoding.niuke.Y2020.A360;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/3/28 19:55
 * author:WLK
 */

public class Q2 {

    @Test
    public void test() {
        Q2 t = new Q2();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] arr = new int[9];
        String[] numbers = line.split(",");
        for(int i = 0;i<9;i++){
            arr[i] =Integer.parseInt(numbers[i]);
        }
        System.out.println(func(arr));

    }


    public static String func(int[] arr){
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for(int i = 0;i<4;i++){
            sum1+=arr[i%9];
            sum2+=arr[(3+i)%9];
            sum3+=arr[(6+i)%9];
        }
        if(sum1==sum2 && sum2==sum3){
            return "yes";
        }else{
            return "no";
        }
    }
}
