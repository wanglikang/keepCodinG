import java.util.Scanner;

public class chongpaiArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k ;
		int num;
		int even2,even4,odd;
		for(int i= 0;i<n;i++) {
			k = scanner.nextInt();
			even2 = 0;
			even4=0;
			odd =0;
			
			
			for(int j = 0;j<k;j++) {
				num = scanner.nextInt();
				if(num%2!=0)
					odd++;
				else if(num%4==0)
					even4++;
				else if(num%2==0)
					even2++;
			}
			if(even2>0) {
				if(even4==odd)
					System.out.println("Yes");
				else System.out.println("No");
			}else if(even4>=odd-1)
				System.out.println("Yes");
			else System.out.println("No");
		}
		
		

	}

}
