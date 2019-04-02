package cn.wlk.keepcoding.SwordOffer;

/***重建二叉树 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * 
 * @author WLK
 *
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution4 {
	public static void main(String[] args) {
		Solution4 s4 = new Solution4();
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode root = s4.reConstructBinaryTree(pre, in);
		s4.showTree(root);
	}

	void showTree(TreeNode node) {
		if (node != null) {
			System.out.println(node.val);
			showTree(node.left);
			showTree(node.right);
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode result =
				dealWith(pre, in, 0, pre.length - 1, 0, in.length - 1);
		return result;
	}

	public TreeNode dealWith(int[] pre, int[] in, int startpre, int endpre, int startin, int endin) {
		if (startpre > endpre) {
			return null;
		}
		if (startpre == endpre) {
			TreeNode result = new TreeNode(pre[startpre]);
			result.left = null;
			result.right = null;
		}

		TreeNode result = new TreeNode(pre[startpre]);
		int mid = find(in, pre[startpre]);
		int leftlength, rightlength;
		leftlength = mid - startin;
		rightlength = endin - mid;

		result.left = dealWith(pre, in, startpre + 1, startpre + leftlength, startin, startin + leftlength - 1);
		result.right = dealWith(pre, in, startpre + leftlength + 1, endpre, startin + leftlength + 1, endin);

		return result;

	}

	public int find(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == target)
				return i;

		return -1;
	}
}
