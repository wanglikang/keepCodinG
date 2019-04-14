package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 2019/4/14-9:21
 * author:WLK
 * <p>
 * 236. 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 解法：类似235那道题,其实解法可以是一模一样了
 */
public class n236 {
    //     * Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        n236 t = new n236();
        TreeNode root = new TreeNode(6);
        TreeNode root2 = new TreeNode(2);
        TreeNode root8 = new TreeNode(8);
        root.left = root2;
        root.right = root8;

        TreeNode root0 = new TreeNode(0);
        TreeNode root4 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        TreeNode root9 = new TreeNode(9);

        root2.left = root0;
        root2.right = root4;
        root8.left = root7;
        root8.right = root9;

        TreeNode root3 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);
        root4.left = root3;
        root4.right = root5;

        TreeNode result = t.lowestCommonAncestor(root, root2, root8);
        System.out.println(result.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();
        findPath(root, p, stack1);
        findPath(root, q, stack2);


        TreeNode last=root;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.peekFirst().val==stack2.peekFirst().val){
                last = stack1.pollFirst();
                stack2.pollFirst();
            }else break;
        }
        return last;
    }
    public void findPath(TreeNode root, TreeNode x, ArrayDeque<TreeNode> stack){
        if(root==null){
            return;
        }
        stack.add(root);
        if(root.val==x.val){
            return;
        }
        findPath(root.left, x, stack);
        if(stack.peekLast().val!=x.val){
            findPath(root.right,x,stack);
            if(stack.peekLast().val!=x.val){
                stack.pollLast();
            }else return;
        }else {
            return ;
        }
    }

}