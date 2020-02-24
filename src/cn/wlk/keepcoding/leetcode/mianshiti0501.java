package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/2/14 15:38
 * author:WLK
 *
 * 面试题 05.01. 插入
 *
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 *
 * 示例1:
 *
 *  输入：N = 10000000000, M = 10011, i = 2, j = 6
 *  输出：N = 10001001100
 *
 * 示例2:
 *
 *  输入： N = 0, M = 11111, i = 0, j = 4
 *  输出：N = 11111
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 垃圾题目，描述不清
 */

public class mianshiti0501 {

    @Test
    public void test() {
        mianshiti0501 t = new mianshiti0501();
//        int result = t.insertBits(1024, 19, 2, 6);
//        int result = t.insertBits(1143207437 ,1017033,11,31);
        int result = t.insertBits(2032243561,10,24,29);//1243714409
        System.out.println(result);
    }
    public int insertBits(int N, int M, int i, int j) {
        int mm = M;
        int k = 31;
        int p = 0x80000000;
        while((mm & 0x80000000)!=0x80000000){
            mm = mm <<1;
            p = p>>1;
            k--;
        }
        p = p<<1;

        int movecount = i;
        while(movecount>0){
            p = (p<<1) | 1;
            movecount--;
            M = M <<1;
        }

        N = N & p;
        N = N | M;

        return N;

    }


    public int insertBits2(int N, int M, int i, int j) {
        int[] l=new int[32];
        int[] r=new int[32];
        int p=1;
        int num,temp,index1=0,index2=0;
        num=N;
        do{
            temp=num%2;
            l[index1++]=temp;
            num=num/2;
        }while(num!=0);
        num=M;
        do{
            temp=num%2;
            r[index2++]=temp;
            num=num/2;
        }while(num!=0);
        index2=0;
        temp=i;
        while(temp<=j){
            l[temp++]=r[index2++];
        }
        num=0;
        for(i=0;i<32;i++){
            num += l[i]*p;
            p=p*2;
        }
        return num;
    }
}
