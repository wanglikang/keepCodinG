/**
 * @author WLK
 * 创建时间: 2018年3月14日 下午8:50:58 
 */
package java1mo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import java1mo.Main.node;

public class ttttttttt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n,m;
		ttttttttt x = new ttttttttt();
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		
		List<node> nodes = new ArrayList<>();
		
				
		int p,q,k;
		for(int i = 0;i<m;i++) {
			p = scanner.nextInt();
			q = scanner.nextInt();
			k = scanner.nextInt();
			node nnn = x.new node(p, q, k);
		//	System.out.println(p+";"+q+";"+k);
			nodes.add(nnn);
		}
		Comparator<node> compa = new Comparator<ttttttttt.node>() {
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
		int count = 0;
		for(;count<n-1&&minindex<m;) {
			tempnode = nodes.get(minindex);
			a = tempnode.p;
			b = tempnode.q;
			//System.out.println(a+"----"+b+"======"+minindex);
			if(!resultset.contains(a) || !resultset.contains(b)) {
//				System.out.println(a+";"+b);
				resultset.add(a);
				resultset.add(b);
				if(maxlen<tempnode.value)
					maxlen = tempnode.value;
				
				count++;
			}
			minindex++;	
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
