package cn.wlk.keepcoding.niuke.Y2020.meituan;

import org.junit.Test;

import java.util.Stack;

/**
 * 2020/3/19 10:48
 * author:WLK
 *
 */


public class Meituan2 {

    @Test
    public void test() {
        Meituan2 t = new Meituan2();

    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        boolean r = func(line);
//        System.out.println(r);
//    }


    public int func(String str,String pattern){
        if(pattern.length()==0){
            return str.length()==0?1:0;
        }
        if(str.length()==0){
            return 0;
        }






        return 1;

    }

}
