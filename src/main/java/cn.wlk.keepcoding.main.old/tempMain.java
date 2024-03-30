/**
 * @author WLK
 * 创建时间: 2018年3月26日 下午10:29:22 
 */

public class tempMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		tempMain m = new tempMain();
		m.aaaa();
		
		
	}
	
	public int aaaa() {
		int a= 5,b = 3;
		a+=a*=++b*3;
		System.out.println(a);
		return 0;
	}

}
