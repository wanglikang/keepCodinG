package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
//done
    //测试用例包括但不限于：

/**
 * {"","",""}
 * {}
 * {"abcd","abcer","abcwew"}
 * {"","c"}
 * {"c","c"}
 * 等
 */
public class n014 {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null)
            return "";
        int n = strs.length;
        if (n == 0)
            return "";
        if (n == 1)
            return strs[0];
        int minlen = strs[0].length();
        int maxlen = strs[0].length();

        for (int i = 0; i < n; i++) {
            if(strs[i].length()==0)
                return "";

            if (minlen > strs[i].length())
                minlen = strs[i].length();

            if (maxlen< strs[i].length())
                maxlen = strs[i].length();
        }
        if(maxlen==0){
            return "";
        }
        char[][] chars = new char[n][];
        for (int i = 0; i < n; i++) {
            chars[i] = strs[i].toCharArray();
        }
        char ch;
        boolean isBreak = false;
        int index = 0;
        for (index = 0; index < minlen && !isBreak; index++) {//对于每一个个字符
            ch = chars[0][index];

            for (int j = 1; j < n && !isBreak; j++) {//依次遍历每一个字符串
                if (ch != chars[j][index])
                    isBreak = true;
            }
        }
        //  System.out.println(index);

//
      if(isBreak){
            return new String(chars[0],0,index-1);
      }else return new String(chars[0],0,minlen);


    }

    @Test
    public void test() {
        n014 t = new n014();
        String[] strs = {"flige", "fliveevevv"};
        System.out.println(t.longestCommonPrefix(strs));
        String[] strs2 = {"c", "c"};
        System.out.println(t.longestCommonPrefix(strs2));
        String[] strs3 = {"", ""};
        System.out.println(t.longestCommonPrefix(strs3));
        String[] str4 = {"flow","flofds","flocvcd"};
        System.out.println(t.longestCommonPrefix(str4));
    }

}
