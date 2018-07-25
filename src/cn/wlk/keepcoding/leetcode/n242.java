package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
//done 垃圾题目
public class n242 {
    /**
     * 本方法考虑的是某个单词只调整了某一个字母的位置的情况，，与题意不符合
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int count = 0;
        int len1 = ch1.length;
        int len2 = ch2.length;
        if (len1 != len2)
            return false;
        if (len1 == 0)
            return true;
        int index1 = 0;
        for (index1 = 0; index1 < len1; index1++) {
            if (ch1[index1] != ch2[index1])
                break;
        }
        int index2 = len1 - 1;
        for (index2 = len1 - 1; index2 >= 0; index2--) {
            if (ch1[index2] != ch2[index2]) {
                break;
            }
        }
        if (index1 > len1 || index2 < 0)
            return false;

        if (ch1[index1] == ch2[index2]) {
            for (int i = index1; i < index2; i++) {
                if (ch2[i] != ch1[i + 1])
                    return false;
            }
        } else if (ch1[index2] == ch2[index1]) {
            for (int i = index1; i < index2; i++) {
                if (ch1[i] != ch2[i + 1])
                    return false;
            }
        } else return false;

        return true;

    }

    public boolean isAnagram(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        if (len1 != len2)
            return false;

        int[] set = new int[26];
        for (int i = 0; i < len1; i++) {
            set[ch1[i] - 'a']++;
        }
        for (int i = 0; i < len1; i++) {
            set[ch2[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (set[i] != 0)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        n242 t = new n242();
        System.out.println(t.isAnagram("adbc", "dbac"));
        System.out.println(t.isAnagram("a", "a"));
    }

}
