package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/4 15:36
 * author:WLK
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * 解法：构造两个辅助数组pre和tail，
 *      pre[i]代表A[0....i-1]的乘积，tail[i]代表A[i+1.....len-1]的乘积，
 *      最后结果result[i]为pre[i]*tail[i];
 */
public class Solution51 {
    @Test
    public void test() {
        Solution51 t = new Solution51();
//        int[] arr = {2,3,4,5,6,7};
        int[] arr = {2};
        int[] result = t.multiply(arr);
        for (int i : result) {
            System.out.print(i+" ");
        }

    }
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] result = new int[len];
        int[] pre = new int[len];
        int[] tail = new int[len];
        pre[0]=1;tail[len-1]=1;
        for(int i = 1;i<len;i++){
            pre[i] = pre[i-1]*A[i-1];
            tail[len-i-1]=tail[len-i-1+1]*A[len-i-1+1];
        }
        for(int i = 0;i<len;i++){
            result[i] = pre[i]*tail[i];
        }
        return result;
    }
}
