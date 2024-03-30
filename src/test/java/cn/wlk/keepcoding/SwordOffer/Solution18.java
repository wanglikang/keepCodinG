package cn.wlk.keepcoding.SwordOffer;
/***二叉树的镜像 
 * 
 *
 *
题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:

二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5


 * @author WLK
 *
 */
public class Solution18 {

	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
    public void Mirror(TreeNode root) {
        mi(root);        
    }
    public void mi(TreeNode node){
        if(node == null)
            return ;
        TreeNode temp  = node.left;
        node.left = node.right;
        node.right = temp;
        mi(node.left);
        mi(node.right);
    }
}
