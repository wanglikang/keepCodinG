package cn.wlk.keepcoding.SwordOffer;

import org.junit.Assert;
import org.junit.Test;

/****** 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 暴力，过关了
 * 更好的解法是：
 * 	从数组的左下角开始比较查找，
 * 		temp>target,则上移,
 * 		temp<target,则右移,直至找到或者越界
 *
 * @author WLK
 *
 */
public class Solution1 {
    public boolean Find(int target, int[][] array) {
        boolean isFind = false;
        for (int i = 0; i < array.length && !isFind; i++)
            for (int j = 0; j < array[0].length && !isFind; j++)
                if (target == array[i][j])
                    isFind = true;
        return isFind;
    }

    /**
     * 更好的解法，应该是从左下角或右上角开始移动都可以
     * @param target
     * @param array
     * @return
     */
    public boolean FindBetter(int target, int[][] array) {
        boolean isFind = false;
        int i = 0,j = array[0].length-1;
        while (!isFind && i < array.length && j >= 0) {
            if (target == array[i][j]) {
                isFind = true;
            }else if(target>array[i][j]){
                i++;
            }else {
                j--;
            }
        }
        return isFind;
    }
    @Test
    public void test() {
        Solution1 s = new Solution1();
        int[] a1 = {1,2,8,9};
        int[] a2 = {2,4,9,12};
        int[] a3 = {4,7,10,13};
        int[] a4 = {6,8,11,15};
        int[][] arr = {a1,a2,a3,a4};
        s.FindBetter(7,arr);
    }

}
