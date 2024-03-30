package cn.wlk.keepcoding.niuke.TiBa;

import org.junit.Test;

/**
 * 2020/4/4 12:23
 * author:WLK
 *
 * 题目描述
 * 旅行Ⅱ
 *
 * 时间限制 :1sec / 空间限制: 256MB
 * 题意：
 *
 * 牛妹出去旅行啦，她准备去NNN个城市旅行，去每个城市的开销是AiA_{i}Ai​元。但是牛妹有强迫症，她想在去y城市之前先旅游x城市，于是牛妹列出了这些限制条件List。并且牛妹很节约，她只有VVV元，她想知道她最多能到多少个城市去旅游。
 * 输入：
 *
 * 给定N,V，A数组，List数组
 * 1≤N≤201 \leq N\leq 20 1≤N≤20
 * 1≤V≤109 1 \leq V \leq 10^{9}1≤V≤109
 * 1≤Ai≤1091 \leq A_{i} \leq 10^{9}1≤Ai​≤109
 * 0≤List.size≤1020 \leq List.size \leq 10^{2}0≤List.size≤102
 *
 *
 * 输出：
 * 一行一个数字表示输出牛妹能去的最多城市数目
 * 示例1
 * 输入
 * 复制
 *
 * 3,10,[3,7,8],[(1,2)]
 *
 * 输出
 * 复制
 *
 * 2
 *
 * 说明
 *
 * 先去1号城市再去2号城市，花费为 3+7=10
 *
 * 备注:
 *
 * A[0]代表1号城市的开销
 * A[1]代表2号城市的开销,以此类推
 *
 *
 */

public class T9 {

     public class Point {
       int x;
       int y;
     }

    @Test
    public void test() {
        T9 t = new T9();
    }

    /**
     *
     * @param N int整型 N
     * @param V int整型 V
     * @param A int整型一维数组 A
     * @param List Point类一维数组 List
     * @return int整型
     */
    public int Travel (int N, int V, int[] A, Point[] List) {
        // write code here
        return 0;
    }


}
