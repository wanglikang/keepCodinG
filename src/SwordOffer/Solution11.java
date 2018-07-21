package SwordOffer;
/*******二进制中1的个数
 * 
 *  输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * @author WLK
 *
 */
public class Solution11 {
	
public static void main(String[] args) {
	Solution11 s11 = new Solution11();
	System.out.println(s11.NumberOf1(-1));
	System.out.println(0xaabd);
			
}
	 public int NumberOf1(int n) {
	        int count = 0;
	        while(n!=0){
	            if((n&1)!=0)
	                count++;
	            n=n>>>1;//此处需要使用不在无符号右移运算，，否则负数会死循环
	            
	        }
	        return count;
	    }
}
