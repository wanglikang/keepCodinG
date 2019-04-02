package cn.wlk.keepcoding.SwordOffer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 2019/4/2 14:27
 * author:WLK
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Solution31 {
    @Test
    public void test() {
        Solution31 t = new Solution31();
        int n = 12132;
        int result1 = t.NumberOf1Between1AndN_Solution(n);
        int result2 = t.NumberOf1Between1AndN(n);
        Assert.assertEquals(result2,result1);
    }
    public int NumberOf1Between1AndN(int n){
        int result = 0;
        for(int i = 0;i<=n;i++){
            result+=getOneNumber(i);
        }

        return result;
    }
    public int getOneNumber(int n) {
        int result = 0;
        while(n>0){
            if(n%10==1){
                result++;
            }
            n = n/10;
        }
        return result;
    }


    /**
     * 来自左神的解法：将数字n按照最高位进行拆分，分成各个区间
     *      对于数字abcdef，先判断（bcdef+1)~abcdef之间的数字的1的个数，再递归的判断1-bcdef之间的1的个数
     *          可以先求最高位的1的个数，在求其余各个位上的最高位，相加即可，需要判断最高位是否为1
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<1){
            return 0;
        }
        int len = getLenOfNum(n);
        if(len ==1)
            return 1;
        int temp = getPowerOf(len-1);
        int first = n/temp;
        int firstOneNum = first==1?n%temp+1:temp;
        int otherOneNum = first*(len-1)*(temp/10);
        return firstOneNum+otherOneNum+NumberOf1Between1AndN_Solution(n%temp);

    }
    public int getLenOfNum(int n ){
        int result = 0;
        while(n>0){
            result++;
            n = n/10;
        }
        return  result;
    }
    public int getPowerOf(int n ){
        return (int)Math.pow(10,n);
    }

}
