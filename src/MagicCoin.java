import java.util.Scanner;

public class MagicCoin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int nn = n;
		String result = "";
		while(n>0) {
			if(n%2==0) {
				result+="2";
				n = n-2;
				n=n/2;
			}else {
				result+="1";
				n = n-1;
				n = n/2;
			}
		}
		
		int k = result.length();
		for(int i = k-1;i>=0;i--)
			System.out.print(result.substring(i, i+1));
		System.out.println("---------------");
		 String re="";
		 re=magic(nn,re);
	     for (int i = re.length()-1; i >= 0; i--) {
	    	 System.out.print(re.charAt(i));
	    	 } 
	}  
	public static String magic(int n,String re) {
		while(n>0){  
			if(n%2==0){  
				re+='2';  
				n=(n-2)/2;  
			}  
			else{  
				re+='1';  
				n=(n-1)/2;  
			}  
		}  
		return re; 
	}
}
