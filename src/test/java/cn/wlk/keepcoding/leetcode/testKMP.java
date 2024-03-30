package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

public class testKMP {
    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;//当某个字符失配时，j(是哟红next数组匹配的时候的变量，不是此函数中的j)指针移动的位置
        while (j < p.length - 1) {
            //k==-1这个条件：就是判断当前最长公共后缀为空，即没有最长公共后缀的时候的时候
            //p[j]==p[k]这个条件：就是用来判断还可以继续组成最长公共后缀
            if (k == -1 || p[j] == p[k]) {
                next[j+1] = k+1;
                j++;
                k++;
            } else {//也就是k!=-1 且 p[j]!=p[k]的时候，通过之前已得到的信息，回溯k
                k = next[k];
            }
        }
        return next;
    }
    @Test
    public void test(){
        int [] next = testKMP.getNext("ababaca");
        Utils.showArray(next);

    }
}
