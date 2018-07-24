package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 350. 两个数组的交集 II
 * <p>
 * 给定两个数组，写一个方法来计算它们的交集。
 * <p>
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 * <p>
 * 注意：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 跟进:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 */
//done
public class n350 {
    public int[] intersect(int[] nums1, int[] nums2) {
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
        int tempresult[]  = new int[maxlen];
        int resultcount = 0;
        while(index1<len1&&index2<len2){
            if(nums1[index1]<nums2[index2]){
                index1++;
            }else if(nums1[index1]>nums2[index2]){
                index2++;
            }else if(nums1[index1]==nums2[index2]){
                tempresult[resultcount++]=nums1[index1];
                index1++;
                index2++;
            }
        }
        int[] result = new int[resultcount];
        for(int i = 0;i<resultcount;i++){
            result[i] = tempresult[i];
        }
        return result;
    }

    @Test
    public void test() {
        n350 n =new n350();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = n.intersect(nums1,nums2);
        for(int i = 0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }

    }

}
