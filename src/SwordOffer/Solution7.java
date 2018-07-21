package SwordOffer;

/********
 * 斐波那契数列
 * 
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。 n<=39
 * 
 * @author WLK
 *
 */
public class Solution7 {
	public static void main(String[] args) {
		Solution7 s7 = new Solution7();
		System.out.println(s7.Fibonacci(34));
		System.out.println(Integer.MAX_VALUE);
	}
	
	/****
	 * 水题
	 * @param n
	 * @return
	 */
	public int Fibonacci(int n) {
		
		
		int[] result = new int[40];
		if (n == 0)
			return 0;
		result[0] = 1;
		result[1] = 1;
		result[2] = 1;
		result[3] = 2;
		for (int i = 4; i <= n; i++)
			result[i] = result[i - 1] + result[i - 2];

		return result[n];

	}

}
