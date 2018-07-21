
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class test {
	public static void main2(String[] args) {
		ArrayList<Integer> arr  = new ArrayList<>();
		arr.add(1);
		arr.add(34);
		arr.add(23);
		arr.add(25);
		Collections.sort(arr,nameComparator);
		for(Integer s:arr)
			System.out.println(s);
		
	}
	public static Comparator<Integer> nameComparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			int n = o1-o2;
			System.out.println(o1+":"+o2+":"+n);
			return n;
		}
	};
	
	
	
	public static void main(String[] args) {
		B bb = new B("11", "22");
		bb.showstr();
		bb.showstrFa();
	}
}
class A1{
	String str1="A1 str1";
	String str2="A1 str2";
	public A1(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}
	
}
class B extends A1{
	String str1="b str1";
	String str2="b str2";
	public B(String str1, String str2) {
		super(str1, str2);
	}
	public void showstr() {
		System.out.println(str1+""+str2);
	}
	public void showstrFa() {
		System.out.println(super.str1+""+super.str2);
	}
}