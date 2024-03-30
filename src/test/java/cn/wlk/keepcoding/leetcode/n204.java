package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 204. 计数质数
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
//done

/**
 * 使用埃拉托色尼筛法
 * 具体是一次筛选掉2的倍数、3的倍数、4的倍数。。。。直到根号n的倍数为止
 */
public class n204 {
    public int countPrimes(int n) {
        if(n<=2)
            return 0;

        boolean[] notPrimes = new boolean[n + 1];
        notPrimes[0]=true;
        notPrimes[1]=true;


        for (int i = 2; i * i < n; i++) {
            if (!notPrimes[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    notPrimes[j] = true;

                }
            }

        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                // System.out.print(i + " ");
                count++;
            }
        }
        return count;

    }

    @Test
    public void test() {
        n204 t = new n204();

        System.out.println(t.countPrimes(10));
    }

}
