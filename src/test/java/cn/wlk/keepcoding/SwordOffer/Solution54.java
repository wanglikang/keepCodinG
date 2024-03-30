package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/7-12:13
 * author:WLK
 * 字符流中第一个不重复的字符
 * <p>
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * <p>
 * 如果当前字符流没有存在出现一次的字符，返回#字符
 * 解法：设一个char数组保存各个char出现的次数
 *      r若某char未出现过，则置-1
 *      若出现过，则置为正数
 *
 *      然后对每个char为负数的，i--
 *
 *      值最小的负数所对应的char就是第一个只出现一次的
 */
public class Solution54 {
    @Test
    public void test() {

        Solution54 t = new Solution54();
        char[] chars = "googlel".toCharArray();
        for(int i = 0;i<chars.length;i++){
            t.Insert(chars[i]);
            System.out.println(t.FirstAppearingOnce());
        }
    }

    public int[] arr = new int[256];
    //Insert one char from stringstream
    public void Insert(char ch) {
        if(arr[ch]==0){
            arr[ch]=-1;
        }else if(arr[ch] <0){
            arr[ch]=1;
        }else {
            arr[ch]++;
        }
        for(int i = 0;i<256;i++){
            if(arr[i]<0){
                arr[i]--;
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int resultindex = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<256;i++){
            if(arr[i]<min) {
                min = arr[i];
                resultindex = i;
            }
        }
        if(min<0){
            return (char)resultindex;
        }else return '#';
    }

}