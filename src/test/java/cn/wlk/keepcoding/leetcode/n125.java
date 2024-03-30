package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
//done
public class n125 {
    public boolean isPalindrome(String s) {
        char[] ch = s.toLowerCase().toCharArray();
        int len = ch.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isLetter(ch[i])||Character.isDigit(ch[i])) {
                ch[index] = ch[i];
                index++;
            }
        }
//        System.out.println(new String(ch,0,index));
        for(int i = 0;i<index/2;i++){
            if(ch[i]!=ch[index-1-i])
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        n125 t = new n125();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(t.isPalindrome("A man, a plan, a canal: Panama"));
//        char[] ch = s.toCharArray();
//        for(int i = 0;i<s.length();i++){
//            System.out.println(ch[i]+":"+Character.isLetter(ch[i]));
//        }

    }

}
