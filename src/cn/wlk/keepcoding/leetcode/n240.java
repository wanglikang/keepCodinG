package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
//done

/**
 * 解法：
 *      奇妙的思路：
 *      从矩阵的左下角开始往右上角遍历
 *
 */
public class n240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length;
        if(i==0)
            return false;
        int j = matrix[0].length;
        if(j==0)
            return false;
        int x1 = i - 1;
        int y1 = 0;

        while (y1 < j && x1 >= 0) {
            //    System.out.println(x1+":"+y1);
            if (matrix[0][y1] == target || matrix[x1][y1] == target)//若在当前列的最上元素或最下元素为target，则返回true
                return true;
            if (target > matrix[x1][y1]) {//比当前列最下边的元素还大，，则应该在下一列中（若存在的话）
                y1++;
            } else if (target > matrix[0][y1]) {//否则，比当前列的最上边的元素还大，则应该在当前列（若存在的话）
                x1--;
            } else return false;//否则，也就是比当前列的最小还小，，则必定不存在
        }
        //遍历完毕还没有找到，，则证明不存在，返回false
        return false;
    }

    @Test
    public void test() {
        n240 t = new n240();
        int[][] nums = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(t.searchMatrix(nums, 13));
        System.out.println(t.searchMatrix(nums, 1));
        System.out.println(t.searchMatrix(nums, 15));
        System.out.println(t.searchMatrix(nums, 18));
        System.out.println(t.searchMatrix(nums, 30));
        System.out.println(t.searchMatrix(nums, 123));
        System.out.println(t.searchMatrix(nums, -1));

    }

}
