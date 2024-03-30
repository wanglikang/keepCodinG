package cn.wlk.keepcoding.SwordOffer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/************从上往下打印二叉树
 *
 * 
题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 
 */
public class Solution22 {
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	        ArrayList<Integer> result = new ArrayList<>();
	        if(root==null)
	            return result;
	        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
	        queue.add(root);
	        TreeNode te ;
	        while(!queue.isEmpty()){
	            te = queue.poll();
	            result.add(te.val);
	            if(te.left!=null)
	            	queue.add(te.left);
	            if(te.right!=null)
	            	queue.add(te.right);
	        }
	        
	        return result;
	    }

}
