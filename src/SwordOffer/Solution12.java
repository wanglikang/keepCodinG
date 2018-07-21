package SwordOffer;

/*******
 * 数值的整数次方 给定一个double类型的浮点数base和int类型的整数exponent。 求base的exponent次方。
 * 
 * @author WLK
 *
 */
public class Solution12 {

	public static void main(String[] args) {
		Solution12 s12 = new Solution12();
		System.out.println(s12.Power2(4, 3));

	}

	public double Power(double base, int exponent) {
		return Math.pow(base, exponent * 1.0);

	}

	
	/**
	 * 比较优的解，利用指数exponent的二进制中1的位数，循环相乘
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double Power2(double base, int exponent) {
		double res = 1, curr = base;
		int n;
		if (exponent > 0) {
			n = exponent;
		} else if (exponent < 0) {
			if (base == 0)
				throw new RuntimeException("分母不能为0");
			n = -exponent;
		} else {// n==0
			return 1;// 0的0次方
		}
		
		while (n != 0) {
			if ((n & 1) == 1)
				res *= curr;
			curr *= curr;// 翻倍
//			
//			System.out.println(res);
//			System.out.println(showBinary(res));
			n >>= 1;// 右移一位
		}
		return  exponent>= 0 ? res : (1 / res);
	}
	
	public String showBinary(double d) {
		Double dou = d;
		return Long.toBinaryString(dou.doubleToRawLongBits(d));
	}
}
