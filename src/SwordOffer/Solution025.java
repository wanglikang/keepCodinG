package SwordOffer;
import java.util.ArrayList;

/**
 * 025-二叉树中和为某一值的路径
 * <p>
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution025 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode root2 = new TreeNode(5);
		TreeNode root3 = new TreeNode(12);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(7);
		root.left = root2;
		root.right = root3;
		root2.left = root4;
		root2.right = root5;

		Solution025 nn = new Solution025();
		ArrayList<ArrayList<Integer>> result = nn.FindPath(root, 22);
		for (ArrayList<Integer> integers : result) {
			for (Integer i : integers) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

	static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null || target < 0) {
			return result;
		}
		if (root.left == null && root.right == null) {//是叶节点
			if (root.val == target) {
				ArrayList<Integer> res = new ArrayList<Integer>();
				res.add(root.val);
				result.add(res);
				return result;
			}
		}
		int subtarget = target - root.val;
		ArrayList<ArrayList<Integer>> subresult1 = FindPath(root.left, subtarget);
		ArrayList<ArrayList<Integer>> subresult2 = FindPath(root.right, subtarget);
		for (ArrayList<Integer> integers : subresult1) {
			integers.add(0, root.val);
			result.add(integers);
		}
		for (ArrayList<Integer> integers : subresult2) {
			integers.add(0, root.val);
			result.add(integers);
		}

		return result;
	}

}
