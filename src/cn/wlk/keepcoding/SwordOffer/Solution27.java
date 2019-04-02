/**
 * @author WLK
 * 创建时间: 2018年2月26日 下午5:36:14 
 */
package cn.wlk.keepcoding.SwordOffer;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*****字符串的排列
 * 
 * 
题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

 * @author WLK
 * 解法:暴力递归，，每次固定一个字符，求其余字符的全排列
 */
public class Solution27 {
    public ArrayList<String> Permutation(String str) {
        HashSet<String> resultSet = new HashSet<>();

        Helper(str.toCharArray(),0,resultSet);

        ArrayList<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }

    public void Helper(char[] chars,int index,HashSet<String> set){
        if(index==chars.length-1){
            set.add(String.valueOf(chars));
        }else {
            for(int i = index;i<chars.length;i++){
                swap(chars,index,i);
                Helper(chars,index+1, set);
                swap(chars,index,i);
            }
        }


    }
    public void swap(char[] chars,int i,int j){
        char t = chars[i];
        chars[i] = chars[j];
        chars[j]= t;
    }


    @Test
    public void test(){
        String str = "abbcd";
        Solution27 s = new Solution27();
        ArrayList<String> result = s.Permutation(str);

        for(String ss:result){
            System.out.println(ss);
        }

    }
}
