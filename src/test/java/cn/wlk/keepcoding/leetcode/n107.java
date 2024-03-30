package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2019/4/16-9:33
 * author:WLK
 * <p>
 * 107. 二叉树的层次遍历 II
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 *
 * 解法：用deque保存自上而下的常规层次遍历即可
 */
public class n107 {
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
        n107 t = new n107();

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result  = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedBlockingQueue<>();
        Queue<TreeNode> queue2 = new LinkedBlockingQueue<>();
        Deque<List<Integer>> deque = new ArrayDeque<>();
        if(root==null){
            return result;
        }
        queue1.add(root);
        TreeNode curr ;
        while(!queue1.isEmpty()){
            List<Integer> subResult = new LinkedList<>();
            while(!queue1.isEmpty()) {
                curr = queue1.poll();
                subResult.add(curr.val);
                if (curr.left != null) {
                    queue2.add(curr.left);
                }
                if (curr.right != null) {
                    queue2.add(curr.right);
                }
            }

            deque.add(subResult);
            Queue<TreeNode> t = queue1;
            queue1 = queue2;
            queue2 = t;
        }

        while(!deque.isEmpty()){
            result.add(deque.pollLast());
        }
        return result;
    }

}