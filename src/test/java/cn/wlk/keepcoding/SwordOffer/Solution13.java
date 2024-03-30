package cn.wlk.keepcoding.SwordOffer;

/******
 * 调整数组顺序使奇数位于偶数前面 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分， 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * 
 * @author WLK
 *
 */
public class Solution13 {
	public static void main(String[] args) {
		Solution13 s13 = new Solution13();
		int[] array = { 1, 3, 5, 7, 2, 4, 6 };
		;
		s13.reOrderArray(array);
		for (int i : array) {
			System.out.println(i);
		}
	}

	/*****
	 * 未完待续
	 * 在原数组上进行操作,插入排序，未完待续
	 * 
	 * @param array
	 */
	public void reOrderArray(int[] array) {
		
	}

	
	/****
	 * 暴力
	 * @param array
	 */
	public void reOrderArray1(int[] array) {
		int len = array.length;
		int[] odd = new int[len];
		int[] even = new int[len];
		int oddcount = 0;
		int evencount = 0;
		for (int i = 0; i < len; i++) {
			if (array[i] % 2 == 0)
				even[evencount++] = array[i];
			else
				odd[oddcount++] = array[i];
		}
		for (int i = 0; i < oddcount; i++)
			array[i] = odd[i];
		for (int i = 0; i < len - oddcount; i++)
			array[i + oddcount] = even[i];

	}

}
