package SwordOffer;

/**
 * 12. 给定一个数字N，打印从1到最大的N位数。
 *
 */
public class Solution012 {
	public static void main(String[] args) {
		Solution012 nn = new Solution012();
		nn.Print(3);
	}

	public  void Print(int n){
		int[] state = new int[n+1];
		while(state[n]!=1){
			printArr(state,n);
			state[0]++;
			for(int i = 0;i<n;i++){
				if(state[i]>9){
					state[i+1]++;
					state[i]=0;
				}else break;
			}

		}
	}
	void printArr(int[] num,int n){
		for(int i = n-1;i>=0;i--){
			System.out.print(num[i]);
		}
		System.out.println();
	}
}
