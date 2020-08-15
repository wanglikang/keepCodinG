package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020/8/15 10:29
 * author:WLK
 */

/**
 * 400. 第N个数字
 *
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *
 * 注意:
 * n 是正数且在32位整数范围内 ( n < 231)。
 *
 * 示例 1:
 *
 * 输入:
 * 3
 *
 * 输出:
 * 3
 *
 * 示例 2:
 *
 * 输入:
 * 11
 *
 * 输出:
 * 0
 *
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 *
 * 解法：
 *  先找出是n是落在几位数的区间内，然后找区间内对应的第几个数，最后找对应这个数字的第几位
 *
 *
 *  done
 */
public class n400 {

    @Test
    public void test() {
        n400 t = new n400();
//        for(int i = 1;i<1001;i++){
//            System.out.print(i);
//        }
//        System.out.println();
        for(int i = 1000000000-40;i<1000000000+40;i++) {
            System.out.print(t.findNthDigit(i));
        }
        System.out.println();
//        System.out.println(t.findNthDigit(100000));
        System.out.println(t.findNthDigit(1000000000));


    }

    public int findNthDigit(int n) {
        if(n<10){
            return n;
        }
        int remainCount = n;
        for(int i = 1;i<100;i++){
             long subCount = getRangeLength(i);

            if(remainCount>subCount){
                remainCount-=subCount;
                continue;
            }else{
                long startNumber = pow(10,i-1);
                int numberIndex =( remainCount-1)/i;
                int numberRemain = remainCount%i-1;
                if(numberRemain==-1){
                    numberRemain = i-1;
                }
                long number = startNumber + numberIndex;
                String str = number+"";
                return Integer.parseInt(str.charAt(numberRemain)+"");
            }
        }
        return 0;
    }

    public long getRangeLength(int i){
        if(i==1){
            return 9;
        }
        long start = pow(10,i-1);
        long end = pow(10,i);
        long numberCount = end-start;
        return  numberCount*i;
    }
    public long pow(int a,int b){

        if(b==0){
            return 0;
        }
        long result = a;
        for(int i = 1;i<b;i++){
            result*=a;
        }

        return result;

    }

    @Test
    public void testGetRangeLength(){
        for(int i = 1;i<10;i++) {
            System.out.println(getRangeLength(i));
        }

    }
}
