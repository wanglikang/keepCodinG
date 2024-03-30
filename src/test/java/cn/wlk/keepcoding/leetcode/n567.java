package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2019/7/3 10:11
 * author:WLK
 * 567. 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 *
 * 注意：
 *
 *     输入的字符串只包含小写字母
 *     两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：判断词频即可，，在每个窗口内进行词频判断
 */
public class n567 {
    @Test
    public void test() {
        n567 t = new n567();
        boolean r = t.checkInclusion("adc", "dcda");
        System.out.println(r);
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1>len2){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0;i<len1;i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        if(isSame(count1,count2))
            return true;

        for(int i = 1;i<=len2-len1;i++){
            count2[s2.charAt(i-1)-'a']--;
            count2[s2.charAt(i+len1-1)-'a']++;
            if(isSame(count1,count2)){
                return true;
            }
        }
        return false;
    }
    public boolean isSame(int[] s1,int[] s2){
        for(int i = 0;i<s1.length;i++){
            if(s1[i]!=s2[i])
                return false;
        }
        return  true;
    }

}
