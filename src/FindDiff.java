import java.util.Scanner;

public class FindDiff {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int i = 0,j = 0;
		for(;i<str1.length()&&j<str2.length();i++,j++) {
			if(chs1[i]==chs2[j])
				continue;
			else break;
		}
		System.out.println(i);
	}

}
