package SwordOffer;
/******树的子结构 
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * @author WLK
 *
 */
public class Solution17 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null)
            return false;
        
        return isSubTree(root1,root2);
        
    }
    public boolean isSubTree(TreeNode tr1,TreeNode tr2){
        if(tr2==null && tr1==null)
            return true;
        if(tr1==null || tr2==null)
            return false;
        
        if(tr1.val==tr2.val){
            if(tr2.left==null &&tr2.right==null)
                return true;
            if(isSubTree(tr1.left,tr2.left)&&isSubTree(tr1.right,tr2.right))
                return true;
        }
        return isSubTree(tr1.left,tr2)||isSubTree(tr1.right,tr2);
    }
}
