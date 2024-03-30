package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 344. 反转字符串
 */
//done
public class n344 {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        String result = "";
        char t ;
        for(int i = 0;i<len/2;i++){
            t = chars[i];
            chars[i] = chars[len-1-i];
            chars[len-1-i] = t;
        }
        return new String(chars);
    }

    @Test
    public void test() {
        n344 t = new n344();
        System.out.println(t.reverseString("hello world"));
    }

}
