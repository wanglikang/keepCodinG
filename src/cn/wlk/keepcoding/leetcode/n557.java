package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2019/4/11-12:29
 * author:WLK
 *
 * 557. 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 *
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 解法：简单反转即可
 */
public class n557 {
    @Test
    public void test() {
        n557 t = new n557();
        System.out.println(t.reverseWords("Let's take LeetCode contest"));
    }
    public String reverseWords(String s) {
        List<char[]> chars = Arrays.stream(s.split(" ")).map(x -> x.toCharArray()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<chars.size();i++){
            sb.append(String.valueOf(reverse(chars.get(i)))+" ");
        }
        sb.delete(sb.length()-1,sb.length());
        return sb.toString();

    }
    public char[] reverse(char[] chars){
        char temp ;
        for(int i = 0;i<chars.length/2;i++){
            temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        return chars;
    }

}