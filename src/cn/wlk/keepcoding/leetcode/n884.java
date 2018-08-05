package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 884. 索引处的解码字符串
 * Weekly Contest 96
 * <p>
 * 给定一个编码字符串 S。为了找出解码字符串并将其写入磁带，从编码字符串中每次读取一个字符，并采取以下步骤：
 * <p>
 * 如果所读的字符是字母，则将该字母写在磁带上。
 * 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "leet2code3", K = 10
 * 输出："o"
 * 解释：
 * 解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
 * 字符串中的第 10 个字母是 "o"。
 * 示例 2：
 * <p>
 * 输入：S = "ha22", K = 5
 * 输出："h"
 * 解释：
 * 解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
 * 示例 3：
 * <p>
 * 输入：S = "a2345678999999999999999", K = 1
 * 输出："a"
 * 解释：
 * 解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= S.length <= 100
 * S 只包含小写字母与数字 2 到 9 。
 * S 以字母开头。
 * 1 <= K <= 10^9
 * 解码后的字符串保证少于 2^63 个字母。
 */

//done

/**
 * 解法：
 *      方法一：直接根据题意构造出来解密后的字符串，然后取第K个，，，结果比赛的时候超时了
 *      方法二：直接通过数学运算，，求出是哪个字母
 *          思路如下：
 *          在解密阶段反向模拟加密：
 *              将解密过程中遇见数字n的时候想象为添加了一个一个的框，每个框里的内容就是当前的字符串，共添加了n-1个框
 *              将解密过程中遇见字符ch时，就是简单的为当前字符串追加了一个字符ch
 *
 *          假设对于加密字符串S ="hah22",K=5;
 *          加密字符串的char数组为chars
 *          预处理阶段：
 *              设变量currLen = 1,i=0;
 *              i代表当前处理的第几个加密字符
 *              currLen代表了当前解密后的字符串的长度，仅仅存储一个长度即可，不用记录具体的解密长度
 *              预处理阶段就是根据题意模拟解密的过程，看代码即可理解，处理直到currLen>=K的值为止，
 *
 *          求出第K个字符的阶段：
 *              根据预处理阶段，要求出的字符必定在长度为currLen的解密字符范围内
 *              设下标j，初始化为i，代表处理到的加密字符串的下标，解密的时候反方向处理，一直处理到第0个加密字符为止
 *              对加密字符chars[j]分情况讨论：
 *                  chars[j]为数字num：
 *                       理解为当前的所有字符串刚好是由num个框组成的
 *                      if 若K刚好等于currLen
 *                          就返回加密字符串当前从右向左第一个字母
 *                      else
 *                          currLen根据当前数字值num进行缩小：currLen = currLen/num;
 *                          同时K也要进行缩小，可以将K缩小到当前所有框的第一个框内的偏移：K = K/currLen;
 *
 *                  chars[j]为字母：
 *                      这种情况为了避免出现陷阱，仅仅认为K等于currLen的时候才认为匹配了当前字母
 *                      也就是
 *                      if(currLen==KK)
 *                          return chars[j]+"";
 *                      否则else
 *                          将当前长度减一，
 *
 *                  此外，当K ==1的时候，就返回加密字符串的第一个字符，因为加密字符以字母开头，
 *                         当K==0的时候，就是刚好匹配当前第currLen个的解密字符，返回地currLen个解密后的字符即可（也就是当前考虑的加密字符串中的最后一个字符）
 *
 *
 */
public class n884 {
    public char findChar(char[] chars, int l, int r) {
        for (int i = r; i >= l; i--) {
            if (Character.isLetter(chars[i]))
                return chars[i];
        }
        return chars[l];
    }

    public String decodeAtIndex(String S, int K) {
        long KK = K;
        char[] chars = S.toCharArray();
        int len = chars.length;
        long currLen = 0;
        int num = 0;
        char result;
        int i;
        for (i = 0; i < len; i++) {
            if (Character.isLetter(chars[i])) {
                currLen++;
                if (KK <= currLen)
                    break;
            } else if (Character.isDigit(chars[i])) {
                num = chars[i] - '0';
                currLen = currLen * num;
                if (KK <= currLen)
                    break;
            }
        }
        if (i >= len) {
            i = len - 1;
        }

       // System.out.println(new String(chars,0,i+1));
        for (int j = i; j >= 0; j--) {
//            System.out.println(j+":"+currLen+":"+KK);
            if(KK==1){
                return chars[0]+"";
            }
            if (Character.isDigit(chars[j])) {//数字
                num = (chars[j] - '0');
                if (KK==0||currLen ==KK) {
                    return findChar(chars, 0, j) + "";
                } else {
                    currLen = currLen /num ;
                    KK = KK % currLen;

                }
            } else if (Character.isLetter(chars[j])) {
               if(KK==0||currLen==KK){
                   return chars[j]+"";
               }else {
                   currLen--;
               }
            }
        }
        return "";

    }

    @Test
    public void test() {
//        String S = "aw4eguc6cs";
//        int K = 41;
//        String S = "vk6";
//        int K = 10;
        String S = "ha22";
        int K = 5;
      //  String S = "lqup4fznamvirw2pf9ant6sv9lj5rve6fdnvm4cbrmpu7pnqa6devbhuzdbqagp8itnsrylgxjkbhloe2gmdy2sc4xu7tljkzl9s";
//                    lqup4fznamvirw2pf9ant6sv9lj5rve6fdnvm4cbrmpu7pnqa6devbhuzdbqagp8
        //int K = 654582184;
        n884 t = new n884();

        System.out.println(t.decodeAtIndex(S, K));
        System.out.println();
    }

}
