package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2019/4/13-10:42
 * author:WLK
 * 89. 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 *
 * 示例 2:
 *
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 *
 * 解法：[0,1,3,2]每项加4然后反转得到[6, 7, 5, 4]，然后将二者拼接起来[0, 1, 3, 2, 6, 7, 5, 4]，就得到n=3的结果，一直递推到n即可
 */
public class n089 {
    @Test
    public void test() {
        n089 t = new n089();
        t.grayCode(5).stream().forEach(x-> System.out.print(x+"\t"));
    }

    /**
     * [0,1,3,2]每项加4然后反转得到[6, 7, 5, 4]，
     * 然后将二者拼接起来[0, 1, 3, 2, 6, 7, 5, 4]，
     * 就得到n=3的结果，一直递推到n即可
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n==0) {
            result.add(0);
            return result;
        }
        if (n==1) {
            result.add(0);
            result.add(1);
            return result;
        }
        result.add(0);
        result.add(1);
        result.add(3);
        result.add(2);
        int count = 2;
        while(n>2) {
            count = count*2;
            final int  llen = count;
            int len = result.size();
            List<Integer> re = result.stream().map(x -> x + llen).collect(Collectors.toList());

            for(int i = re.size()-1;i>=0;i--){
                result.add(re.get(i));
            }
             n = n - 1;
        }
        return result;
    }

    public List<Integer> grayCode_leetcode(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 1<<n; ++i)
            result.add(i ^ i>>1);
        return result;
    }

}