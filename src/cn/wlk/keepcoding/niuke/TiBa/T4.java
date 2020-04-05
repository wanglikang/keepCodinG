package cn.wlk.keepcoding.niuke.TiBa;

import org.junit.Test;

/**
 * 2020/4/3 17:22
 * author:WLK
 *
 * 牛妹的蛋糕
 众所周知，牛妹非常喜欢吃蛋糕。
 第一天牛妹吃掉蛋糕总数三分之一多一个，第二天又将剩下的蛋糕吃掉三分之一多一个，以后每天吃掉前一天剩下的三分之一多一个，到第n天准备吃的时候只剩下一个蛋糕。
 牛妹想知道第一天开始吃的时候蛋糕一共有多少呢？

 示例1
 输入
 复制

 2

 输出
 复制

 3

 示例2
 输入
 复制

 4

 输出
 复制

 10

 备注:

 0<n< 30


 *
 * 解法：倒推即可
 */

public class T4 {

    @Test
    public void test() {
        T4 t = new T4();
        System.out.println(t.cakeNumber(4));//16
    }
    /**
     *
     * @param n int整型 只剩下一只蛋糕的时候是在第n天发生的．
     * @return int整型
     */
    public int cakeNumber (int n) {
        int sum =1;
        for(int i = 1;i<n;i++){
            sum = (sum+1)*3/2;
        }
        return sum;
    }

}
