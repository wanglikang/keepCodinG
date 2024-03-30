package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020/2/2 17:35
 * author:WLK
 *
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 *     拆分时可以重复使用字典中的单词。
 *     你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：借鉴别人的题解，，
 *      动态规划,dp[i]代表了s[0,i)的子字符串是否可以被字典组成
 *              遍历所有子字符串[i,j]
 *              若dp[i-1]==true,,则代表之前的子字符串可以被字典组成，若此子字符串也包含在字典中，，则dp[j]也为true，
 *
 *
 */

public class n139 {

    @Test
    public void test() {

        n139 t = new n139();
        String s = "leetcode";
        List<String> words = new ArrayList<String>();
        words.add("leet");
        words.add("code");
        System.out.println(t.wordBreak(s,words));
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        boolean[] dp =new boolean[n+1];
        dp[0]=true;

        for(int j =1;j<=n;j++){
            for(int i = 0;i<j;i++){

                if(dp[i] && wordDict.contains(s.substring(i,j))){
                    dp[j]=true;
                    break;
                }
            }
        }
        return dp[n];
    }


}
