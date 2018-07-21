import java.util.Scanner;

public class qiushuliedehe {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double a;
		int n;
		double sum = 0;
		while(scanner.hasNext()) {
			sum=0;
			a = scanner.nextDouble();
			n = scanner.nextInt();
			sum+=a;
			for(int i= 1;i<n;i++) {
				a = Math.sqrt(a);
				sum+=a;
			}
			System.out.printf("%.2f",sum);
		}
		

	}
}
