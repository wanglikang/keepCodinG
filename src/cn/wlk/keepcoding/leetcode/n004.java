package cn.wlk.keepcoding.leetcode;

import org.junit.Test;


/**
 * 4 无重复字符的最长子串
 *
 */
public class n004 {

    public boolean isOk(char[] chars, int startIndex, int endIndex) {
        int arr[] = new int[27];
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[chars[i] - 'a'] > 0)
                return false;
            else
                arr[chars[i] - 'a']++;
        }

        return true;

    }

    /**
     * 解题方法：
     *  做一个滑动窗口，窗口内的字符带表了最长子串的内容。
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
        int[] set = new int[265];
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0;//最长字符串窗口的最左端指针。
        int result = 0;
        for (int i = 0; i < len; i++) {
            if(set[chars[i]]==0 || set[chars[i]]<left){
                result = Math.max(result,i-left+1);
            }else left = set[chars[i]];
            set[chars[i]] = i+1;
        }
        return result;
    }

    @Test
    public void test() {
n003 n = new n003();
        System.out.println(n.lengthOfLongestSubstring("abcabcbb"));
    }

}
