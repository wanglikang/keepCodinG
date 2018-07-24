package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组，写一个函数来计算它们的交集。
 *
 * 例子:
 *
 *  给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
 *
 * 提示:
 *
 * 每个在结果中的元素必定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
//done
public class n349 {
    public int[] intersection(int[] nums1, int[] nums2) {

            Arrays.sort(nums1);
            Arrays.sort(nums2);
            //Utils.showArray(nums1);
            //Utils.showArray(nums2);

            int len1 = nums1.length;
            int len2 = nums2.length;
            int maxlen = Math.max(len1,len2);
            int index1,index2;
            index1 = 0;
            index2 = 0;
            Set<Integer> resultset  = new HashSet<>();
            int resultcount = 0;
            while(index1<len1&&index2<len2){
                if(nums1[index1]<nums2[index2]){
                    index1++;
                }else if(nums1[index1]>nums2[index2]){
                    index2++;
                }else if(nums1[index1]==nums2[index2]){
                    resultset.add(nums1[index1]);
                    index1++;
                    index2++;
                }
            }
            int[] result = new int[resultset.size()];
            Iterator<Integer> iterable = resultset.iterator();
            while(iterable.hasNext()){
                result[resultcount++] = iterable.next();
            }

            return result;


    }
    @Test
    public void test() {

    }

}
