package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/3 15:06
 * author:WLK
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 * 解法：二分查找即可，然后在进行左右遍历
 */
public class Solution37 {
    @Test
    public void test() {
        Solution37 t = new Solution37();
//        int[] arr = {1, 2, 3, 4, 4, 4, 5, 5, 5, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9};
//        for(int i = 1;i<=9;i++)
//            System.out.println(t.GetNumberOfK(arr, i));
        int[] arr = {1,2,3,4,5};
        System.out.println(t.GetNumberOfK(arr, 7));
    }

    public int GetNumberOfK(int[] array, int k) {

        int index = binarySearch(array, k);
        int len = array.length;
        int l = index;
        int r = index + 1;
        int result = 0;
        while (l >= 0 && array[l] == k) {
            result++;
            l--;
        }
        while (r < len && array[r] == k) {
            result++;
            r++;
        }
        return result;
    }

    /**
     * 二分查找，对mid不匹配的时候，left=mid+1或rifht=mid-1，而不是=mid，否则会死循环
     * @param array
     * @param k
     * @return
     */
    public int binarySearch(int[] array, int k) {
        int len = array.length;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left < right ) {
            mid = left + (right - left) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] > k) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
//        if(left==right && array[left]==k){
//            return left;
//        }else
            return -1;
    }

}
