package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 *
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class n202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int x = n;
        int sum = 0;
        int t;
        while(x!=1){

            sum = 0;
            while(x>0){
                t = x%10;
                sum = sum+t*t;
                x = x/10;
            }
            System.out.println(sum);
            if(set.contains(sum))
                return false;
            set.add(sum);
            x = sum;
        }
        return true;
    }

    @Test
    public void test() {
        n202 t = new n202();
        System.out.println(t.isHappy(19));
        System.out.println();
    }

}
