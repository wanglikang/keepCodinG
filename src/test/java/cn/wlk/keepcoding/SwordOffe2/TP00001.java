package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/3/7 22:09
 * author:WLK
 *
 *
 * 牛客网，，2017年腾讯编程题 1
 */

public class TP00001 {

    @Test
    public void test() {
        TP00001 t = new TP00001();
        System.out.println(t.ttt("a"));
        System.out.println(t.ttt("aa"));
        System.out.println(t.ttt("aaa"));
        System.out.println(t.ttt("aaaa"));
        System.out.println(t.ttt("aaab"));
        System.out.println("------");
        System.out.println(t.ttt("b"));
        System.out.println(t.ttt("ba"));
        System.out.println(t.ttt("baa"));
        System.out.println(t.ttt("baaa"));
        System.out.println(t.ttt("baab"));

        System.out.println("------");
        System.out.println(t.ttt("baca"));


    }


    public int ttt(String s){
        int factor = 25;

        int factor0 = 1;//第四个
        int factor1 = 25 + 1 ;//第三个
        int factor2 = 25 * factor1 + 1;//第二个
        int factor3 = 25 * factor2 + 1;//第一个
        char[] chars = s.toCharArray();

        if(s.length()==1){
            return (chars[0]-'a') * factor3;

        }else if(s.length()==2){
            return (chars[0]-'a')* factor3 + 1
                    + (chars[1] - 'a')*factor2;

        }else if(s.length()==3){
            return (chars[0]-'a')* factor3 + 1
                    + (chars[1] - 'a')*factor2 + 1
                    + (chars[2] - 'a')* factor1;
        }else{
            return (chars[0]-'a')* factor3 + 1
                    + (chars[1] - 'a')*factor2 + 1
                    + (chars[2] - 'a')* factor1 + 1
                    + (chars[3] - 'a')*factor0;
        }

    }


}
