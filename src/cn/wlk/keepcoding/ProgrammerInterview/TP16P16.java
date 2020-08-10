package cn.wlk.keepcoding.ProgrammerInterview;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

/**
 * 2020/4/24 12:13
 * author:WLK
 *
 * 面试题 16.16. 部分排序
 *
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 *
 * 示例：
 *
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 *
 * 提示：
 *
 *     0 <= len(array) <= 1000000
 *
 *
 */

public class TP16P16 {

    @Test
    public void test() {
        TP16P16 t = new TP16P16();
        int[] array = new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19};
        Utils.showArray(t.subSort(array));
    }

    public int[] subSort(int[] array) {
        String s = "";
        s.toCharArray();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = array.length;
        if(n<2){
            return new int[]{-1,-1};
        }
        int l=-1,r=-1;
        for(int i = 0;i<n;i++){
            if(array[i]>=max){
                max = Math.max(array[i],max);
            }else{
                r = i;
            }

            if(array[n-1-i] <= min){
                min = Math.min(array[n-1-i],min);
            }else{
                l = n-1-i;
            }

        }

        return new int[]{l,r};
    }

}
