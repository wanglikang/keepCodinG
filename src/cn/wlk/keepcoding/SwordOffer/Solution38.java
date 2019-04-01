package cn.wlk.keepcoding.SwordOffer;

/*******二叉树的深度
 * 
 *
 输入一棵二叉树，求该树的深度。
 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

 * @author WLK
 *
 */
public class Solution38 {

     class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

	public static void main(String[] args) {
		int a [] = {1,2,43,43,3};
		int bbb[];
		bbb = new int[10];
		Solution38 s = new Solution38();

		TreeNode root1=s.new TreeNode(10);
		TreeNode root2=s.new TreeNode(5);
		TreeNode root3=s.new TreeNode(12);
		TreeNode root4=s.new TreeNode(4);
		TreeNode root5=s.new TreeNode(7);
		root1.left = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;

		Solution38 n = new Solution38();
        System.out.println(n.TreeDepth(root1));
				
	}

    public int TreeDepth(TreeNode root) {
        int result = 0;
        int a = 0;
        if(root!=null){
            if(root.left!=null){
                result = Math.max(result,TreeDepth(root.left));
            }
            if(root.right!=null){
                result = Math.max(result,TreeDepth(root.right));
            }
            result+=1;

        }
        return result;

    }
}
