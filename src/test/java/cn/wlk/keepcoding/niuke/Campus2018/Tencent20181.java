package cn.wlk.keepcoding.niuke.Campus2018;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020/3/8 9:43
 * author:WLK
 */

public class Tencent20181 {

    @Test
    public void test() {
        Tencent20181 t = new Tencent20181();
    }


    public static void main(String[] argc){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long m= scanner.nextInt();
        long plus = m*m;
        long size = n/2/m;
        long result = size*plus;
        System.out.println(result);



    }
}
