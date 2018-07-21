import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javax.sound.midi.Synthesizer;

/**
 * @author WLK 创建时间: 2018年3月24日 下午7:44:47
 */

public class toutiao3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		String str = "";
		for (int i = 0; i < n; i++) {
			str = scanner.nextLine();
			String result = dowith(str);
		}

	}

	private static String dowith(String str) {
		
		
		return "";
	}
	
	private static boolean isOp(String ch) {
		return ("+".equals(ch)||"-".equals(ch)||"*".equals(ch)||"/".equals(ch));
	}
}
