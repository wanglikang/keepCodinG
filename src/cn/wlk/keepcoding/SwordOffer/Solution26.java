/**
 * @author WLK
 * 创建时间: 2018年2月26日 下午4:34:13 
 */
package cn.wlk.keepcoding.SwordOffer;

/******
 * 二叉搜索树与双向链表
 * 
 * 题目描述 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author WLK
 */
public class Solution26 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public static void main(String[] args) {
		Solution26 s = new Solution26();
		TreeNode root1 = s.new TreeNode(10);
		TreeNode root2 = s.new TreeNode(6);
		TreeNode root3 = s.new TreeNode(14);
		TreeNode root4 = s.new TreeNode(4);
		TreeNode root5 = s.new TreeNode(8);
		TreeNode root6 = s.new TreeNode(12);
		TreeNode root7 = s.new TreeNode(16);
		root1.left = root2;
		root1.right = root3;
		
		root2.left = root4;
//		root2.right = root5;
		
//		root3.left = root6;
		root3.right = root7;
		TreeNode result = s.Convert(root1);
		while(result!=null) {
			System.out.println(result.val);
			result = result.right;
		}
	}

	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree==null)
            return null;
		TreeNode result = dooo(pRootOfTree);
		TreeNode ttt = null;
		
		TreeNode tail = link(pRootOfTree, ttt);
		tail.right = null;
		return result;
	}
	
	/**
	 * 
	 * 因为题目不允许额外新建节点空间，所有先找到最小的元素节点，用于返回
	 * @param tree
	 * @return
	 */
	public TreeNode dooo(TreeNode tree) {
		TreeNode result = tree;
		while(result.left!=null)
			result = result.left;
		return result;
	}

	/**
	 * 线索化的一种，link函数分别递归地连接：
	 * 1.tree.left's subTree to tree
	 * 2.tree to tree.right's subTree
	 * 
	 * @param tree
	 *            当前节点
	 * @param pre
	 *            顺序访问中当前节点之前的节点
	 * @return 返回tree的最右边的子节点
	 */
	public TreeNode link(TreeNode tree, TreeNode pre) {
		TreeNode temppre = pre;

		if (tree.left != null) {
			temppre = link(tree.left, pre);
			temppre.right = tree;
			tree.left = temppre;
		} else {
			if(pre!=null)
				pre.right = tree;
			tree.left = pre;
		}
		if (tree.right != null) {
			return link(tree.right, tree);
		} else
			return tree;

	}

}
