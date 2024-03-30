package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
//done
public class n118 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int resultarr[] = new int[numRows*(numRows+1)/2+1];
        resultarr[0] = 1;
        resultarr[1] = 1;
        ArrayList<Integer> re1 = new ArrayList<>();
        re1.add(1);
        result.add(re1);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> re = new ArrayList<>();
            resultarr[i * (i - 1) / 2 + 1] = 1;
            re.add(resultarr[i * (i - 1) / 2 + 1]);
            for (int j = 2; j < i; j++) {
                resultarr[i * (i - 1) / 2 + j] =    resultarr[(i - 1) * (i - 2) / 2 + j - 1] +
                                                    resultarr[(i - 1) * (i - 2) / 2 + j];
                re.add(resultarr[i * (i - 1) / 2 + j]);

            }
            resultarr[i * (i - 1) / 2 + i] = 1;
            re.add(resultarr[i * (i - 1) / 2 + i]);
            result.add(re);
        }
        return result;
    }

    @Test
    public void test() {
        n118 t = new n118();
        List<List<Integer>> result = t.generate(1);
        Iterator<List<Integer>> iterable = result.iterator();
        while(iterable.hasNext()){
            List<Integer> li = iterable.next();
            for(int i:li){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}
