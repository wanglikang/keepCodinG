package SwordOffer;
/******跳台阶 
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author WLK
 *
 */
public class Solution8 {
	 static int[] arr = new int[1000];
	    static{
	        arr[0] = 0;
	        arr[1] = 1;
	        arr[2] = 2;
	        for(int q = 3;q<1000;q++)
	            arr[q] = arr[q-1] + arr[q-2];
	    }
	        
		public int JumpFloor(int target) {
	        return arr[target];
	    }
}
