/**
 * @author WLK
 * 创建时间: 2018年3月14日 下午7:51:22 
 */
package java1mo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



public class Main {
	
	static int n,m;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main x = new Main();
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		
		List<node> nodes = new ArrayList<>();
		
				
		int p,q,k;
		for(int i = 0;i<m;i++) {
			p = scanner.nextInt();
			q = scanner.nextInt();
			k = scanner.nextInt();
			node n = x.new node(p, q, k);
			nodes.add(n);
		}
		Comparator<node> compa = new Comparator<Main.node>() {
			@Override
			public int compare(node o1, node o2) {
				// TODO Auto-generated method stub
				return o1.value-o2.value;
			}
		};
		nodes.sort(compa);
		//Iterator<node> iterator = nodes.iterator();
//		while(iterator.hasNext())
//			System.out.println(iterator.next());
		int minindex = 0;
		Set<Integer> resultset = new HashSet<>();
		int a,b,v;
		node tempnode=null;
		int maxlen = 0;
		for(;resultset.size()<n;) {
			tempnode = nodes.get(minindex);
			a = tempnode.p;
			b = tempnode.q;
			if(!resultset.contains(a) || !resultset.contains(b)) {
//				System.out.println(a+";"+b);
				resultset.add(a);
				resultset.add(b);
				if(maxlen<tempnode.value)
					maxlen = tempnode.value;
				minindex++;
			}
		}
		System.out.println(maxlen);
//		System.out.println(resultset.size());
		
	}
	public class node{
		int p,q;
		int value;
		node(int a,int b,int v){
			this.value = v;
			this.q = a;
			this.p = b;
		}
		@Override
		public String toString() {
			return "node [p=" + p + ", q=" + q + ", value=" + value + "]";
		}
	
		
	}

}
