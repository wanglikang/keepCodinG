package cn.wlk.keepcoding.leetcode;

import com.sun.org.apache.regexp.internal.REUtil;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 2019/4/10-11:00
 * author:WLK
 * 简单题
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 解法：先找到正负的分界点，然后每次从绝对值最小的数开始求平方即可
 */
public class n977 {
    @Test
    public void test() {
        n977 t = new n977();
        int[] arr = {-7,-3,2,3,11};
        Arrays.stream(t.sortedSquares(arr)).forEach(x-> System.out.print(x+" "));
    }

    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] result = new int[len];
        if (len == 1) {
            result[0] = A[0] * A[0];
            return result;
        }

        int startIndex = -1;
        int index = 1;
        int last = A[0];
        int lindex, rindex;
        while (A[index] < 0) {
            if (last * A[index] <= 0) {
                break;
            }
            last = A[index];
            index++;
        }
        lindex = index-1;
        rindex = index;
        int resultindex = 0;
        while (lindex >= 0 && rindex < len) {
            if (Math.abs(A[lindex]) < Math.abs(A[rindex])) {
                result[resultindex] = A[lindex] * A[lindex];
                lindex--;
            } else {
                result[resultindex] = A[rindex] * A[rindex];
                rindex++;
            }
            resultindex++;
        }
        while (lindex >= 0) {
            result[resultindex++] = A[lindex] * A[lindex];
            lindex--;
        }
        while (rindex < len) {
            result[resultindex++] = A[rindex] * A[rindex];
            rindex++;
        }
        return result;
    }

}