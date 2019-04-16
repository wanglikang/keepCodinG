package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2019/4/16-10:19
 * author:WLK
 *
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 解法：简单题，使用java8的流操作，更方便
 *
 */
public class n058 {
    @Test
    public void test() {
        n058 t = new n058();
        System.out.println(t.lengthOfLastWord("  "));
    }

    public int lengthOfLastWord(String s) {


        List<String> words = Arrays.stream(s.split(" ")).filter(x -> x.length() > 0).collect(Collectors.toList());
        int len = words.size();
        if(len>0){
            return words.get(len-1).length();
        }else return 0;
    }
}