package SwordOffer;

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
	 public boolean Find(int target, int [][] array) {
	        boolean isFind = false;
	        for(int i = 0;i<array.length&&!isFind;i++)
	            for(int j = 0;j<array[0].length&&!isFind;j++)
	                if(target==array[i][j])
	                    isFind = true;
	        return isFind;
	    }
}
