package SwordOffer;
/******矩形覆盖 
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * @author WLK
 *
 */
public class Solution10 {
	public static void main(String[] args) {
		Solution10 s10 = new Solution10();
		System.out.println(s10.RectCover(1));
		System.out.println(s10.RectCover(2));
		System.out.println(s10.RectCover(3));
		System.out.println(s10.RectCover(4));
		System.out.println(s10.RectCover(5));
		System.out.println(s10.RectCover(6));
		System.out.println(s10.RectCover(7));
		System.out.println(s10.RectCover(8));
		
				
	}
	
	/***
	 * 原来还是斐波那契数列
	 * 只不过是前几项不同而已
	 * 
	 * @param target
	 * @return
	 */
    public int RectCover(int target) {
        if(target==0)
            return 0;
        if(target==1)
            return 1;
        int n  = target;
        int[] arr = new int[n+5];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 5;
        for(int i = 5;i<=n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[target];


    }
}
