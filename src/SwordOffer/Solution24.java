package SwordOffer;

import java.util.ArrayList;
import java.util.Stack;

/*******二叉树中和为某一值的路径 
 * 
 * 
题目描述
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

 * @author WLK
 *
 */
public class Solution24 {
	public static void main(String[] args) {
		int a [] = {1,2,43,43,3};
		int bbb[];
		bbb = new int[10];
		Solution24 s = new Solution24();
		
		TreeNode root1=s.new TreeNode(10);
		TreeNode root2=s.new TreeNode(5);
		TreeNode root3=s.new TreeNode(12);
		TreeNode root4=s.new TreeNode(4);
		TreeNode root5=s.new TreeNode(7);
		root1.left = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;
		
		int target = 	22;
		ArrayList<ArrayList<Integer>> result = s.FindPath(root1, target);
		for(ArrayList<Integer> set:result) {
			for(Integer i:set)
				System.out.print(i+" ");
			System.out.println();
		}
				
	}
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
    public static int sumval = 0;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null)
            return result;
        tryNode(root,target,result,stack);
        return result;
    }
    public void tryNode(TreeNode root,int target
    		,ArrayList<ArrayList<Integer>> result,Stack<TreeNode> stack ){
        if(root!=null){
            stack.add(root);
            sumval+=root.val;
        }else return ;
        
        if(sumval==target&&root.left==null&&root.right==null){//bingo
            result.add(addStack(stack));
        }else if(sumval<target){
            tryNode(root.left,target,result,stack);
            tryNode(root.right,target,result,stack);
            
        }
        
        sumval-=root.val;
        stack.pop();
    }
    
    public ArrayList<Integer> addStack(Stack<TreeNode> stack){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> tempstack = new Stack<TreeNode>();
        while(!stack.isEmpty()){
            tempstack.add(stack.pop());
        }
        while(!tempstack.isEmpty()){
            result.add(tempstack.peek().val);
            stack.add(tempstack.pop());
        }
        return result;
    }
}
