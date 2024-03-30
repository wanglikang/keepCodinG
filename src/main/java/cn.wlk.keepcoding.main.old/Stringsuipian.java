import java.util.Scanner;

public class Stringsuipian {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str  = scanner.next();
		char ch = str.charAt(0);
		int num  = 1;
		int i = 1;
		while(i<str.length()) {
			if(ch!=str.charAt(i))
				num++;			
			i++;
		}
		System.out.println(str.length()*1.0/num);
	}

}
