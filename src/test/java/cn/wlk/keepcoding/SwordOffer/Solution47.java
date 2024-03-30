package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/4 14:22
 * author:WLK
 * 求1+2+3+...+n
 *
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 解法：神奇的解法，使用&&短路运算符来进行判断
 */
public class Solution47 {
    @Test
    public void test() {
        Solution47 t = new Solution47();
        System.out.println(t.Sum_Solution(10));

    }
    public int Sum_Solution(int n) {
       int result= n;
       boolean b = result!=0 && (result+=Sum_Solution(n-1))==1;

       return result;
    }

}
