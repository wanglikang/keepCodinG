package cn.wlk.keepcoding.leetcode;

import org.junit.Test;


/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例：
 * <p>
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 *
 *
 * 解法：滑动窗口
 *      一个hash表，存对应字符的下标值
 *      一个滑动窗口【left,i】，代表了当前窗口内，最长的子串长度
 */
public class n003 {

    /**
     * 解题方法：
     *  做一个滑动窗口，窗口内的字符代表了最长子串的内容。
     *  窗口的左边界指针为left，右边界为当前的i
     *  分情况讨论：
     *  对当前的下标i所对应的字符ch，
     *      1.若此字符是第一次出现，则加入此窗口即可，同时哈希表中增加此字符的键值
     *      2.若此字符出现过，且最后一次出现在窗口内，则将left指针移动到窗口内的下标位置（通过哈希表进行），
     *      3.若此字符出现过，但最后一次出现在窗口外，则将此字符加入当前窗口，更改一下哈希表中此字符的键值对。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] set = new int[265];//保存对应字符上一次出现的位置下标
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0;//最长字符串窗口的最左端指针。
        int result = 0;//结果，即最长的无重复子串的长度
        //滑动窗口的下标范围为【left、right】
        for (int right = 0; right < len; right++) {
            if(set[chars[right]]==0 || set[chars[right]]<left){
                result = Math.max(result,right-left+1);
            }else {
                //因为是求的无重复的子串，所以，遇到有重复的情况，就可以重置窗口了
                //即，将left置为上一次重复的位置
                left = set[chars[right]];
            }
            set[chars[right]] = right+1;
        }
        return result;
    }

    @Test
    public void test() {
		n003 n = new n003();
        System.out.println(n.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(n.lengthOfLongestSubstring("bbbbb"));
        System.out.println(n.lengthOfLongestSubstring("pwwkew"));

    }

}
