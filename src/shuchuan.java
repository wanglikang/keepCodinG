import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class shuchuan {
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int n;
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			ArrayList<String> nums = new ArrayList();
			for (int i = 0; i < n; i++) {
				nums.add(scanner.next());
			}

			Collections.sort(nums,nameComparator2);
			for (String s : nums)
				System.out.print(s);
			System.out.println();
		}

	}

	public static Comparator<String> nameComparator = new Comparator<String>() {
		@Override
		public int compare(String str1, String str2) {
			int len1 = str1.length();
			int len2 = str2.length();
			char[] chs1 ;
			char[] chs2 ;
			int t;
			chs1 = str1.toCharArray();
			chs2 = str2.toCharArray();
			int i = 0,j = 0;
			if(len1>len2) {
				while(i<len1) {
					j = 0;
					for(;j<len2&&i<len1;j++,i++) {
						if(chs1[i]==chs2[j])
							continue;
						if(chs1[i]>chs2[j])
							return -1;
						else if(chs1[i]<chs2[j])
							return 1;
					}
				}
				
			}else if(len2>len1) {
				while(j<len2) {
					i = 0;
					for(;i<len1&&j<len2;i++,j++) {
						if(chs1[i]==chs2[j])
							continue;
						if(chs1[i]>chs2[j])
							return -1;
						else if(chs1[i]<chs2[j])
							return 1;
					}
				}
				
			}else return str2.compareTo(str1);
				
			return 0;
		
		}
		
		
		public int aa(String str1,String str2) {

			System.out.println(str1+":"+str2);
			int len1 = str1.length();
			int len2 = str2.length();
			char[] chs1 ;
			char[] chs2 ;

			int t;
			//make sure len>>len2
			if(len1<len2) {
				t = len1;
				len1 = len2;
				len2 = t;
				chs1 = str2.toCharArray();
				chs2 = str1.toCharArray();
			}
			else {
				chs1 = str1.toCharArray();
				chs2 = str2.toCharArray();
			}
			int i = 0,j = 0;
			
			if(len1==len2)
				return str2.compareTo(str1);
			int aa  = str2.compareTo(str1.substring(0, len2));
			if(aa!=0)
				return aa;
			else return str2.compareTo(str1.substring(len2, len1));
		}
	};

	public static Comparator<String> nameComparator2 = new Comparator<String>() {
		@Override
		public int compare(String str1, String str2) {
			String t1 = str1+str2;
			String t2 = str2+str1;
			return t2.compareTo(t1);
		}
		
	};

}