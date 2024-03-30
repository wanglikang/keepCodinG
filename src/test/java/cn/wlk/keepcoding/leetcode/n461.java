package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 461. 汉明距离
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */
//done
public class n461 {
    public int hammingDistance(int x, int y) {
        int n  = x^y;
        int result = 0;
        for(int i = 0;i<32;i++){
            if((n&0x00000001)==1)
                result++;
            n=n>>1;
        }
        return result;

    }
    @Test
    public void test() {
        n461 t = new n461();
        System.out.println(t.hammingDistance(1,4));
    }

}
