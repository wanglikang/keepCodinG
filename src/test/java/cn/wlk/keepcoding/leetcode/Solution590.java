package cn.wlk.keepcoding.leetcode;

import java.util.*;

/**
 * 590. N叉树的后序遍历
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Solution590 {
	static class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val,List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
	static Node buildTree(){
		Node n8 = new Node(8,null);
			ArrayList<Node> ar1 = new ArrayList<>();
			ar1.add(n8);
		Node n7 = new Node(7,ar1);
		Node n6 = new Node(6,null);
			ArrayList<Node> ar2 = new ArrayList<>();
			ar2.add(n6);
			ar2.add(n7);
		Node n3 = new Node(3,ar2);
		Node n5 = new Node(5,null);
			ArrayList<Node> ar3 = new ArrayList<>();
			ar3.add(n5);
		Node n2 = new Node(2,ar3);
		Node n4 = new Node(4,null);
			ArrayList<Node> ar4 = new ArrayList<>();
			ar4.add(n2);
			ar4.add(n3);
			ar4.add(n4);
		Node root = new Node(1,ar4);

		return  root;
	}
	public static void main(String[] args) {
		Solution590 s = new Solution590();
		Node root = s.buildTree();
		List<Integer> result = s.postorder(root);
		for (Integer e : result) {
			System.out.println(e);
		}
//		s.postorder2(root);

	}
	public void  postorder2(Node root){
		if(root.children!=null) {
			for (Node child : root.children) {
				postorder2(child);
			}
		}
		System.out.println(root.val);
	}
	public List<Integer> postorder(Node root) {
		Stack<Node> stack = new Stack<>();
		HashMap<Node,Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		if(root==null)
			return result;
		stack.add(root);
		map.put(root,0);
		Node p;
		while(!stack.isEmpty()){
			p = stack.peek();
			if(map.get(p)==0){//
				if(p.children!=null) {
					for(int i = p.children.size()-1;i>=0;i--){
						stack.add(p.children.get(i));
						map.put(p.children.get(i), 0);
					}
				}
				map.put(p,1);
			}else if(map.get(p)==1){
				result.add(p.val);
				stack.pop();
			}
		}
		return result;
	}

}
