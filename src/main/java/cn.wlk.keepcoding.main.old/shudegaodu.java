import java.util.Scanner;

public class shudegaodu {
	static int[][] tree;
	public static void main(String[] args) {
		tree = new int[5002][2];
		for(int i = 0;i<5002;i++) {
			tree[i] = new int[2];
			tree[i][0] =tree[i][1] =-1;  
		}
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int fa,chi;
		for(int i = 0;i<n-1;i++) {
			fa = scanner.nextInt();
			chi = scanner.nextInt();
			addchird(fa,chi);
		}
		System.out.println(findhigh(0));
		

	}
	public static void addchird(int fa,int chi) {
		if(tree[fa][0]==-1)
			tree[fa][0]=chi;
		else if(tree[fa][1]==-1)
			tree[fa][1]=chi;
	}
	public static int findhigh(int k) {
//		System.out.println("k:"+k);
		if(-1==k)
			return 0;
		int left = findhigh(tree[k][0])+1;
		int right = findhigh(tree[k][1])+1;
		return Math.max(left, right);
	}
}
