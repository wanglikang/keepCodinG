package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/1/29 14:03
 * author:WLK
 * <p>
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：动态规划：dp[j],表示从arr[0,j]为止，所有可能的解码方式个数
 *  则，
 *      若arr[j-1,j]符合要求，                        则dp[j]=dp[j-1]*1
 *      若arr[j-2,j-1]符合要求且arr[j-1,j]符合要求，   则dp[j]=dp[j-1]+dp[j-2];
 *
 *      其它情况逐一考虑即可
 */

public class n091 {

    @Test
    public void test() {


//        String s1 = "123456";
//        String s1  = "2263224";
//        String s1  = "110";
//        String s1  = "230";
//        String s1 = "301";
//        String s1 = "10";
//          String s1 = " 99";
        String s1 = "1010";

        n091 t = new n091();
        int r = t.numDecodings(s1);
        System.out.println(r);
    }

    /**
     * 首位一定不能为0
     * @param c 数字数组
     * @param i 下标
     * @return 返回c[i,i+1]这两位字符代表的数是否是 A-Z
     */
    public int isUnderZ(char[] c, int i) {
        if(c[i]=='0') {
            return 0;
        }
        if (c[i] < '2') {
            return 1;
        } else {
            if (c[i] == '2' && c[i + 1] <= '6') {
                return 1;
            }
        }
        return 0;
    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        //dp[j] :以s[0:j]结尾（包含）的子字符串的的可能编码个数
        int[] dp = new int[n];

        if (n==0 || chars[0] == '0') {
            return 0;
        }
        if(n==1){
            return 1;
        }
        dp[0] = 1;

        for (int j = 1; j < n; j++) {
            if (chars[j]=='0'){
                if(chars[j-1]=='0' || chars[j-1] >'2'){
                    return 0;
                }else{
                    dp[j]=j>1?dp[j-2]:1;
                }
            }else{
                if(isUnderZ(chars,j-1)!=0){
                    if(j<2){
                        dp[j]=dp[j-1]+1;
                    }else {
                        if(isUnderZ(chars,j-2)!=0){
                            dp[j]=dp[j-1]+dp[j-2];
                        }else{
                            dp[j]=dp[j-1]*2;
                        }
                    }
                }else{
                    dp[j]=dp[j-1];
                }
            }
        }
        return dp[n - 1];
    }

}
