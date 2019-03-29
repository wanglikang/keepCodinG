package cn.wlk.keepcoding.niuke.Campus2018;

import javax.sound.midi.Soundbank;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 2019/3/29 10:38
 * author:WLK
 */

/**
 * 题目描述 计算重复字符串的长度
 * <p>
 * 请从字符串中找出至少重复一次的子字符串的最大长度
 * 输入描述:
 * <p>
 * 字符串，长度不超过1000
 * <p>
 * 输出描述:
 * <p>
 * 重复子串的长度，不存在输出0
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * ababcdabcefsgg
 * <p>
 * 输出
 * 复制
 * <p>
 * 3
 * <p>
 * 说明
 * <p>
 * abc为重复的最大子串，长度为3
 * 解法：暴力枚举，因为是求最长的，就先长度最长的子串开始判断起，第一个找到的就是最长的重复子串
 */
public class longestRepeatSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for(int len = s.length()-2;len>=1;len--){
            Set<String> set = new HashSet<>();
            for(int i = 0;i<s.length()-len;i++){
                String subStr = s.substring(i,i+len);
                if(set.contains(subStr)){
                    System.out.println(len);
                    return ;
                }
                set.add(subStr);
            }
        }
        System.out.println(0);
    }
}
