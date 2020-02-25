package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2020/2/25 18:01
 * author:WLK
 *
 * 面试题 01.04. 回文排列
 *
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：使用set，成对儿的去重，最后判断set的size是否小于2即可。
 */

public class TP01P04 {

    @Test
    public void test() {
        TP01P04 t = new TP01P04();
        System.out.println(t.canPermutePalindrome("tatctcoa"));
    }

    public boolean canPermutePalindrome(String s) {

        char[] chars = s.toCharArray();
        Set<Character> sset = new HashSet<>();

        int n = chars.length;
        for(int i = 0;i<n;i++){
            if(sset.contains(chars[i])){
                sset.remove(chars[i]);
            }else{
                sset.add(chars[i]);
            }
        }
        return sset.size()<2;





    }

}
