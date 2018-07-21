import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author WLK
 * 创建时间: 2018年3月24日 下午7:19:27 
 */

public class toutiao1 {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		Scanner scanner = new Scanner(System.in);
		int n,k;
		n = scanner.nextInt();
		k = scanner.nextInt();
		Set<Long> numset = new HashSet<>();
		List<Long> list = new ArrayList<>();
		
		int i = 0,j = 0;
		for(i = 0;i<n;i++) {
			numset.add(scanner.nextLong());
		}
		long len  = numset.size();
		Iterator<Long> it = numset.iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		Collections.sort(list);
		
		int result = 0;
		for(i = 0;i<len;i++) {
			for(j = i;j<len;j++) {
				if((list.get(j)-list.get(i))==k) {
					result++;
				}
			}
		}

		System.out.println(result);
	}

}
