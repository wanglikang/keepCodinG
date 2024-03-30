package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 2020/3/5 23:07
 * author:WLK
 *
 * 面试题50. 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 解法：简单题；用set
 *
 */

public class TP050 {

    @Test
    public void test() {
        TP050 t = new TP050();
        System.out.println(t.firstUniqChar("abaccdeff"));
    }

    public char firstUniqChar(String s) {
        Set<Character> sset = new HashSet();
        LinkedBlockingDeque<Character> deq = new LinkedBlockingDeque<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for(int i =0;i<n;i++){
//            if(!sset.constaint(chars[i])){
            if(!sset.contains(chars[i])){
                deq.add(chars[i]);
                sset.add(chars[i]);
            }else{
                deq.pollFirst();
            }
        }

        return deq.size()>0?deq.pollFirst():' ';


    }


}
