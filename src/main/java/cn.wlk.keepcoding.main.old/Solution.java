import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
		int col = triangle.size();
		for (int i = 0; i < triangle.size(); i++) {
			dp.add(new ArrayList<Integer>());
			for (int j = 0; j < triangle.get(i).size(); j++) {
				dp.get(i).add(0);
			}
		}

		dp.get(0).set(0, triangle.get(0).get(0));
		for (int i = 1; i < triangle.size(); i++) {
			dp.get(i).set(0, dp.get(i - 1).get(0) + triangle.get(i).get(0));
			dp.get(i).set(triangle.get(i).size() - 1,
					dp.get(i - 1).get(dp.get(i - 1).size() - 1) + triangle.get(i).get(triangle.get(i).size() - 1));
			for (int j = 1; j < triangle.get(i).size() - 1; j++) {
				dp.get(i).set(j, Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + triangle.get(i).get(j));
			}
		}
		int min = Integer.MAX_VALUE;
		for (int j = triangle.get(col - 1).size() - 1; j >= 0; j--) {
			if (dp.get(col - 1).get(j) < min)
				min = dp.get(col - 1).get(j);
		}

		return min;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(2);
		ArrayList<Integer> a2 = new ArrayList<>();
		a2.add(3);
		a2.add(4);
		ArrayList<Integer> a3 = new ArrayList<>();
		a3.add(6);
		a3.add(5);
		a3.add(7);
		ArrayList<Integer> a4 = new ArrayList<>();
		a4.add(4);
		a4.add(1);
		a4.add(8);
		a4.add(3);
		triangle.add(a1);
		triangle.add(a2);
		triangle.add(a3);
		triangle.add(a4);
		System.out.println(new Solution().minimumTotal(triangle));
	}
}

class Solution1 {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		  if(root==null)
	            return ;
		int count = 0;
		int next = 1;
		ArrayList<Queue<TreeLinkNode>> queues = new ArrayList<>();
		queues.add(new LinkedList<>());
		queues.add(new LinkedList<>());
		queues.get(count).add(root);
		TreeLinkNode t1 = null;
		TreeLinkNode t2 = null;
		
		while(!queues.get(0).isEmpty()||!queues.get(1).isEmpty()) {
			t1 = queues.get(count).poll();
			if(t1.left!=null)queues.get(next).add(t1.left);
			if(t1.right!=null)queues.get(next).add(t1.right);
			t2 = queues.get(count).peek();
			t1.next = t2;
			if(t2==null) {
				count=(count+1)%2;
				next=(next+1)%2;
			}
			
		}
		

	}
}