package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 2019/4/3 10:58
 * author:WLK
 * 第一个只出现一次的字符
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 解法：扫描，统计词频，减一，再逐个判断；
 *          对每一个字符统计词频，再全部将词频减去1，
 *          然后在顺序判断每个字符的词频是不是等于0，是则为答案，否则继续词频减一
 */
public class Solution34 {
    @Test
    public void test() {
        Solution34 t = new Solution34();
        System.out.println(t.FirstNotRepeatingChar("abcdefgabdefg"));
    }
    public int FirstNotRepeatingChar(String str) {
        char[] chars=str.toCharArray();
        int[] count = new int[256];
        for(int i = 0;i<chars.length;i++){
            count[chars[i]]++;
        }
//        for(int i = 0;i<chars.length;i++){
//            System.out.print(chars[i]+":"+count[chars[i]]+"\t");
//        }
//        System.out.println();
        for(int i = 0;i<count.length;i++){
            count[i]--;
        }
//        for(int i = 0;i<chars.length;i++){
//            System.out.print(chars[i]+":"+count[chars[i]]+"\t");
//        }
//        System.out.println();
        for(int i = 0;i<chars.length;i++){
            if(count[chars[i]]==0){
                return i;
            }
            count[i]--;
        }
        return -1;
    }

}
