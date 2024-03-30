import java.util.Scanner;

public class daishuguohe {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		boolean[] canCovered = new boolean[n];
		for(int i = 0;i<n;i++) {
			arr[i] = scanner.nextInt();
			canCovered[i] = false;
		}
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<arr[i];j++)
				canCovered[j] = true;
		}
		
		for(int i = 0;i<n;i++)
			if(canCovered[i]==false)
				break;
	}
}
