package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 ** Also, a self-dividing number is not allowed to contain the digit zero.
 ** Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 ** Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 *
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 *
 */

/**
 * 728. 自除数
 */
public class n728 {
    /**
     * @param i
     * @return
     */
    public boolean isSelfDiv(int i){
        int num = i;
        int[] numm = new int[10];
        int count = 0;
        for(;i>0;){
            numm[count]=i%10;
            if(numm[count]==0)
                return false;
            if(num%numm[count]!=0)
                return false;
            i = i/10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i =left;i<=right;i++){
//            System.out.println("deal:"+i);
            if(isSelfDiv(i))
                result.add(i);
        }
        return result;
    }

    @Test
    public void test() {
        n728 n = new n728();
        List<Integer> result = n.selfDividingNumbers(1, 22);
        for(Integer i :result){
            System.out.print(i+" ");
        }

    }

}
