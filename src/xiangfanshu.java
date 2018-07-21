import java.util.Scanner;

public class xiangfanshu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String num = scanner.next();
		int i = 0;
		int jinwei = 0;
		int j = num.length()-1;
		int ii,jj,temp;
		String result = "";
		for(;j>=0;j--) {
			ii = Integer.parseInt(num.substring(i, i+1));
			jj = Integer.parseInt(num.substring(j,j+1));
			temp = (ii+jj+jinwei)%10;
			jinwei = (ii+jj)/10;
			
			result=temp+""+result;
			i++;
		}
		System.out.println(result);
	}

}
